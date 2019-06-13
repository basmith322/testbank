package com.uleska.testbank.controller;

import com.uleska.testbank.Context;
import com.uleska.testbank.dao.AccountsDAO;
import com.uleska.testbank.dao.ConfigDAO;
import com.uleska.testbank.dao.LoginDAO;
import com.uleska.testbank.util.Util;
import com.uleska.validators.UleskaException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
class WebController {

    private static final String accountsPermission = "accounts";
    private static final String configurationPermission = "configuration";
    private static final String editAccountPermission = "editaccount";
    private static final String editConfigPermission = "editconfig";
    private static final String saveAccountPermission = "saveaccount";
    private static final String saveConfigPermission = "saveconfig";
    private static final String searchAccountsPermission = "searchaccounts";
    private static final String transactionsPermission = "transactions";
    private static final String systemPermission = "system";
    private final LoginDAO loginDAO;
    private final AccountsDAO accDAO;
    private final ConfigDAO configDAO;

    public WebController() {
        loginDAO = new LoginDAO();
        accDAO = new AccountsDAO();
        configDAO = new ConfigDAO();
    }

    @PostMapping("/login")
    public ModelAndView login(HttpSession session, HttpServletRequest request) {
        String name = request.getParameter("inputName");
        String password = request.getParameter("inputPassword");

        if (name == null || password == null) {
            return new ModelAndView("/error.jsp");
        }

        try {
            Context.getDataValidators().validateTestBankName(name);
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }

        session.setAttribute("name", name);

        String role = loginDAO.getRole(name);

        if (role == null) {
            return new ModelAndView("/error.jsp");
        }

        session.setAttribute("role", role);

        if (role.equals("admin")) {
            return new ModelAndView("/configuration.jsp");
        } else {
            return new ModelAndView("/accounts.jsp");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("/index.jsp");
    }

    @RequestMapping(value = "/accounts", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView accounts(HttpServletRequest request) {
        return checkAuthorizedAndRedirect(request, accountsPermission, "/accounts.jsp");
    }

    @RequestMapping(value = "/configuration", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView configuration(HttpServletRequest request) {
        return checkAuthorizedAndRedirect(request, configurationPermission, "/configuration.jsp");
    }

    @RequestMapping(value = "/editaccount", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editAccount(HttpServletRequest request) {
        if (!Context.getAuthUtil().Authorized(request, editAccountPermission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        String versionId = request.getParameter("hiddenID");

        try {
            Context.getDataValidators().validateTestBankId(versionId);
            request.setAttribute("version_id", versionId.trim());
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }

        if (Util.isNumber(versionId)) {
            request.setAttribute("version_id", versionId.trim());
        } else {
            return new ModelAndView("/error.jsp");
        }

        return new ModelAndView("/editaccounts.jsp");
    }

    @RequestMapping(value = "/editconfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editConfig(HttpServletRequest request) {
        if (!Context.getAuthUtil().Authorized(request, editConfigPermission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        String versionId = request.getParameter("hiddenID");

        try {
            Context.getDataValidators().validateTestBankId(versionId);
            request.setAttribute("version_id", versionId.trim());
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }

        if (Util.isNumber(versionId)) {
            request.setAttribute("version_id", versionId.trim());
        } else {
            return new ModelAndView("/error.jsp");
        }

        return new ModelAndView("/editconfig.jsp");
    }

    @RequestMapping(value = "/saveaccount", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView saveAccount(HttpServletRequest request) {
        if (!Context.getAuthUtil().Authorized(request, saveConfigPermission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        String versionId = request.getParameter("hiddenID");
        String overdraft = request.getParameter("overdraft");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String type = request.getParameter("type");

        try {
            Context.getDataValidators().validateTestBankId(versionId);
            request.setAttribute("version_id", versionId.trim());
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }

        try {
            if (overdraft != null && !overdraft.isEmpty()) {
                if (!Context.getAuthUtil().Authorized(request, saveAccountPermission + ":overdraft")) {
                    throw new UleskaException();
                }

                try {
                    Context.getDataValidators().validateTestbankOverdraft(overdraft);
                    accDAO.UpdateOverdraft(versionId, overdraft.trim());
                } catch (UleskaException e) {
                    e.printStackTrace();
                    return new ModelAndView("/error.jsp");
                }
            }


            if (name != null && !name.isEmpty()) {
                try {
                    Context.getDataValidators().validateTestBankName(name);
                    accDAO.UpdateName(versionId, name.trim());
                } catch (UleskaException e) {
                    e.printStackTrace();
                    return new ModelAndView("/error.jsp");
                }
            }


            if (address != null && !address.isEmpty()) {
                try {
                    Context.getDataValidators().validateTestBankAddress(address);
                    accDAO.UpdateAddress(versionId, address.trim());
                } catch (UleskaException e) {
                    e.printStackTrace();
                    return new ModelAndView("/error.jsp");
                }
            }


            if (type != null && !type.isEmpty() && (type.compareTo("nochange") != 0)) {
                if (!Context.getAuthUtil().Authorized(request, saveAccountPermission + ":type")) {
                    throw new UleskaException();
                }

                try {
                    Context.getDataValidators().validateTestbankAccounttype(type);
                    accDAO.UpdateAccountType(versionId, type.trim());
                } catch (UleskaException e) {
                    e.printStackTrace();
                    return new ModelAndView("/error.jsp");
                }
            }
        } catch (UleskaException e) {
            return new ModelAndView("/notauthorized.jsp");
        }
        return new ModelAndView("/editaccounts.jsp");
    }

    @RequestMapping(value = "/saveconfig", method = {RequestMethod.GET, RequestMethod.POST})
    private ModelAndView saveconfig(HttpServletRequest request) {
        if (!Context.getAuthUtil().Authorized(request, saveConfigPermission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        String versionId = request.getParameter("hiddenID");
        String value = request.getParameter("value");

        try {
            Context.getDataValidators().validateTestBankId(versionId);
            request.setAttribute("version_id", versionId.trim());
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }


        if (value != null && !value.isEmpty()) {
            try {
                Context.getDataValidators().validateTestbankValue(value);
                configDAO.UpdateConfig(versionId, value.trim());
            } catch (UleskaException e) {
                e.printStackTrace();
                return new ModelAndView("/error.jsp");
            }
        } else {
            return new ModelAndView("/error.jsp");
        }
        return new ModelAndView("/configuration.jsp");
    }

    @RequestMapping(value = "/searchaccount", method = {RequestMethod.GET, RequestMethod.POST})
    private ModelAndView searchAccount(HttpServletRequest request) {
        if (!Context.getAuthUtil().Authorized(request, searchAccountsPermission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        String searchterm = request.getParameter("searchterm");

        try {
            Context.getDataValidators().validateTestbankSearchterm(searchterm);
            request.setAttribute("searchterm", searchterm.trim());
        } catch (UleskaException e) {
            e.printStackTrace();
            return new ModelAndView("/error.jsp");
        }
        return new ModelAndView("/searchaccounts.jsp");
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView root(HttpServletRequest request) {
        return new ModelAndView("/index.jsp");
    }

    @RequestMapping(value = "/transactions", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView transactions(HttpServletRequest request) {
        return checkAuthorizedAndRedirect(request, transactionsPermission, "/transactions.jsp");
    }

    @RequestMapping(value = "/system", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView system(HttpServletRequest request) {
        return checkAuthorizedAndRedirect(request, systemPermission, "/system.jsp");
    }

    private ModelAndView checkAuthorizedAndRedirect(HttpServletRequest request, String permission, String redirect) {
        if (!Context.getAuthUtil().Authorized(request, permission)) {
            return new ModelAndView("/notauthorized.jsp");
        }

        return new ModelAndView(redirect);
    }

}
