$(document).ready(function () {

    // Invoke the corresponding URL to update the dynamic fields section using Ajax
    $('.dynamic-update-rows').on('click', 'button[data-dynamic-update-rows-url]', function () {
    	//event event.preventDefault();
        let url = $(this).data('dynamic-update-rows-url');

        // adding the row index, needed when deleting a dynamic row
        let formData = $('form').serializeArray();
        let param = {};
        param["name"] = $(this).attr('name');
        param["value"] = $(this).val();
        formData.push(param);

        // updating the dynamic section
        $('#dynamicTableContents').load(url, formData);
    });

    // autodismiss alerts
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
});