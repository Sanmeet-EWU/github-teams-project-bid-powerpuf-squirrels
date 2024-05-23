$(document).ready(function() {
    $("form").on("submit", function(event) {
        event.preventDefault();
        var form = $(this);
        var index = form.find("input[name='index']").val();

        $.ajax({
            type: "POST",
            url: form.attr("action"),
            data: { index: index },
            success: function(response) {
                // Display the response message
                alert(response);
            },
            error: function(xhr, status, error) {
                alert("An error occurred: " + xhr.responseText);
            }
        });
    });
});
