$(document).ready(function() {

	// On Edit Press of the Administration Validator populate the Name, Type,
	// PresetValue
	// and make the add button a save and show the close button.
	// Uses a hidden input field to pass the id up for the edit update button functionality.
	$(".edit_av").click(function() {

		var id = $(this).data("id");

		var name = $(".name_av_" + id).text().trim();
		var type = $(".type_av_" + id).text().trim();
		var presetValue = $(".presetValue_av_" + id).text().trim();

		$("#presetValue_av_input").val(presetValue);
		$('#name_av_input').val(name);

		$('#type_av_select option').filter(function() {
			return ($(this).text() == type);
		}).prop('selected', true);

		$('#av_submit').removeClass('btn-primary');
		$('#av_submit').addClass('btn-success');

		$('#av_submit').text('Save');
		$('#av_submit').attr('name', 'av_save_submit');

		$('#hidden_av_id').val(id);

		$("#av_close").show();
	});

	// hide the Administration Validator close button
	$("#av_close").click(function() {

		$("#av_close").hide();
	});

	$(".edit_sl").click(function() {

		var id = $(this).data("slid");
		var name = $(".name_sl_" + id).text().trim();
		var enc_in_transit = $(".enc_in_transit_sl_" + id).text().trim();
		var enc_at_rest = $(".enc_at_rest_sl_" + id).text().trim();
		var csrf = $(".csrf_sl_" + id).text().trim();
		var input_validation = $(".input_validation_sl_" + id).text().trim();

		$('#name_sl_input').val(name);

		if (enc_in_transit == "true") {

			$('#enc_in_transit_true').prop("checked", true);
			$('#enc_in_transit_false').prop("checked", false);
		} else {

			$('#enc_in_transit_true').prop("checked", false);
			$('#enc_in_transit_false').prop("checked", true);
		}

		if (enc_at_rest == "true") {

			$('#enc_at_rest_true').prop("checked", true);
			$('#enc_at_rest_false').prop("checked", false);
		} else {

			$('#enc_at_rest_true').prop("checked", false);
			$('#enc_at_rest_false').prop("checked", true);
		}

		if (csrf == "true") {
			
			$('#csrf_true').prop("checked", true);
			$('#csrf_false').prop("checked", false);
		} else {
			$('#csrf_true').prop("checked", false);
			$('#csrf_false').prop("checked", true);
		}

		if (input_validation == "true") {
			
			$('#input_validation_true').prop("checked", true);
			$('#input_validation_false').prop("checked", false);
		} else {
			$('#input_validation_true').prop("checked", false);
			$('#input_validation_false').prop("checked", true);
		}
		
		$('#sl_submit').removeClass('btn-primary');
		$('#sl_submit').addClass('btn-success');

		$('#sl_submit').text('Save');
		$('#sl_submit').attr('name', 'sl_save_submit');
		
		$('#hidden_sl_id').val(id);
		
		$("#sl_close").show();
	});
	
	$("#sl_close").click(function() {

		$("#sl_close").hide();
	});
	
	$(".edit_dsr").click(function() {
		
		var id = $(this).data("dsrid");
		
		var title = $(".title_dsr_" + id).text().trim();
		var description = $(".desc_dsr_" + id).text().trim();

		$('#title_dsr_input').val(title);
		$('#desc_dsr_input').val(description);
		
		$('#dsr_submit').removeClass('btn-primary');
		$('#dsr_submit').addClass('btn-success');
		
		$('#dsr_submit').text('Save');
		$('#dsr_submit').attr('name', 'dsr_save_submit');
		
		$('#hidden_dsr_id').val(id);
		
		$("#dsr_close").show();
	});
	
	
	$("#dsr_close").click(function(){
		
		$("#dsr_close").hide();
	});
});
