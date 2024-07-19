
document.addEventListener("DOMContentLoaded", function() {
    // Get all rating bar divs
    const ratingBars = document.querySelectorAll(".rating_bar");

    // Loop through each rating bar
    ratingBars.forEach((bar, index) => {
        // Get all the spans inside the rating bar
        const rateSpans = bar.querySelectorAll(".rate");

        // Attach a click event listener to each span
        rateSpans.forEach((span, rateIndex) => {
            span.addEventListener("click", function() {
                // Find the corresponding form by constructing its ID
                const formId = "star-rating-" + (index);
                const form = document.getElementById(formId);

                // Set the rating value in the form
                form.querySelector('input[name="rating"]').value = rateIndex + 1;

                // Submit the form
                form.submit();
            });
        });
    });
});