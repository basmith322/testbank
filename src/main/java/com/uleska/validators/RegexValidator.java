package com.uleska.validators;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;


public class RegexValidator {

    private static final ArrayList<String> eventhandlers = new ArrayList<>(

        Arrays.asList("fscommand", "onabort", "onactivate", "onafterrrint", "onafterupdate",
            "onbeforeactivate", "onbeforecopy", "onbeforecut", "onbeforedeactivate",
            "onbeforeeditfocus", "onbeforepaste", "onbeforeprint", "onbeforeunload",
            "onbeforeupdate", "onbegin", "onblur", "onbounce", "oncellchange",
            "onchange", "onclick", "oncontextmenu", "oncontrolselect", "oncopy",
            "oncut", "ondataavailable", "ondatasetchanged", "ondatasetcomplete",
            "ondblclick", "ondeactivate", "ondrag", "ondragend", "ondragleave",
            "ondragenter", "ondragover", "ondragdrop", "ondragstart", "ondrop",
            "onend", "onerror", "onerrorupdate", "onfilterchange", "onfinish",
            "onfocus", "onfocusin", "onfocusout", "onhashchange", "onhelp",
            "oninput", "onkeydown", "onkeypress", "onkeyup", "onlayoutcomplete",
            "onload", "onlosecapture", "onmediacomplete", "onmediaerror", "onmessage",
            "onmousedown", "onmouseenter", "onmouseleave", "onmousemove", "onmouseout",
            "onmouseover", "onmouseup", "onmousewheel", "onmove", "onmoveend", "onmovestart",
            "onoffline", "ononline", "onoutofsync", "onpaste", "onpause", "onpopstate",
            "onprogress", "onpropertychange", "onreadystatechange", "onredo", "onrepeat",
            "onreset", "onresize", "onresizeend", "onresizestart", "onresume", "onreverse",
            "onrowsenter", "onrowexit", "onrowdelete", "onrowinserted", "onscroll", "onseek",
            "onselect", "onselectionchange", "onselectstart", "onstart", "onstop", "onstorage",
            "onsyncrestored", "onsubmit", "ontimeerror", "ontrackchange", "onundo", "onunload",
            "onurlflip", "seeksegmenttime"));


    private static final ArrayList<String> htmltags = new ArrayList<>(

        Arrays.asList("<!DOCTYPE", "<a", "<abbr", "<acronym", "<address", "<applet", "<area", "<article",
            "<aside", "<audio", "<b", "<base", "<basefont", "<bdi", "<bdo", "<big", "<blockquote",
            "<body", "<br", "<button", "<canvas", "<caption", "<center", "<cite", "<code", "<col",
            "<colgroup", "<datalist", "<dd", "<del", "<details", "<dfn", "<dialog", "<dir", "<div",
            "<dl", "<dt", "<em", "<embed", "<fieldset", "<figcaption", "<figure", "<font", "<footer",
            "<form", "<frame", "<frameset", "<h\\d", "<head", "<header", "<hr", "<html", "<i", "<iframe",
            "<img", "<input", "<ins", "<kbd", "<keygen", "<label", "<legend", "<li", "<link", "<main",
            "<map", "<mark", "<menu", "<menuitem", "<meta", "<meter", "<nav", "<noframes", "<noscript",
            "<object", "<ol", "<optgroup", "<option", "<output", "<p", "<param", "<picture", "<pre",
            "<progress", "<q", "<rp", "<rt", "<ruby", "<s", "<samp", "<script", "<section", "<select",
            "<small", "<source", "<span", "<strike", "<strong", "<style", "<style>", "<sub", "<summary",
            "<sup", "<table", "<tbody", "<td", "<textarea", "<tfoot", "<th", "<thead", "<time", "<title",
            "<tr", "<track", "<tt", "<u", "<ul", "<var", "<video", "<wbr"));


    public static void validateRegexInput(String input, String regex) throws UleskaException {
        try {
            boolean valid = input.matches(regex);

            if (!valid) {
                throw new UleskaException("Target [" + input + "] does not match expected input.");
            }

            if (IsRegexVulnerable(regex)) {
                CheckForMaliciousInput(CleanInput(input));
            }

        } catch (PatternSyntaxException e) {
            throw new UleskaException(e.getMessage());
        }
    }


    private static boolean IsRegexVulnerable(String regex) throws UleskaException {
        String doublequote = "\"";
        String singlequote = "'";
        String lessthan = "<";

        try {
            if (singlequote.matches(regex) || doublequote.matches(regex) || lessthan.matches(regex)) {
                return true;
            }
        } catch (PatternSyntaxException e) {
            throw new UleskaException(e.getMessage());
        }

        return false;
    }


    private static String CleanInput(String input) throws UleskaException {
        try {
            boolean changed, anychange;
            String after;
            String before = input;

            do {
                anychange = false;
                do {
                    after = before.replaceAll("(?s)<!--.*?-->", "");

                    if (!before.equals(after)) {
                        changed = true;
                        anychange = true;
                        before = after;
                    } else {
                        changed = false;
                    }
                }
                while (changed);

                do {
                    try {
                        after = URLDecoder.decode(before, "UTF-8");

                        if (!before.equals(after)) {
                            changed = true;
                            anychange = true;
                            before = after;
                        } else {
                            changed = false;
                        }
                    } catch (java.io.UnsupportedEncodingException e) {
                        // Note this can be thrown when there's & with something that doesn't
                        // match a URL pattern, e.g. %&()
                        //
                        // That shouldn't stop the handling of this input, but also
                        // shouldn't result in an infinite loop
                        //
                        //throw new UleskaException(e.getMessage());
                    }

                }
                while (changed);
            }
            while (anychange);

            return after;
        } catch (PatternSyntaxException e) {
            throw new UleskaException(e.getMessage());
        }
    }


    private static void CheckForMaliciousInput(String input) throws UleskaException {
        if (input.matches(".*<.*[sS][cC][rR][iI][pP][tT].*")) {
            throw new UleskaException("Potentially malicious javascript tag found in input ["
                + input + "].");
        }

        String lcinput = input.toLowerCase();

        for (String handler : eventhandlers) {
            if (lcinput.matches(".*<.*" + handler + ".*")) {
                throw new UleskaException("Potentially malicious string [" + handler +
                    "] found in input [" + input + "].");
            }
        }

        for (String tag : htmltags) {
            if (lcinput.matches(".*" + tag + "\\s.*")) {
                throw new UleskaException("Potentially malicious string [" + tag +
                    "] found in input [" + input + "].");
            }
        }
    }

}

