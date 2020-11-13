$(document).ready(function () {

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (subscription, status) {
            $('.myForm #id').val(subscription.id);
            $('.myForm #companyName').val(subscription.prize);
            $('.myForm #companyName').val(subscription.prize);
        });
        $('.myForm #exampleModal').modal();

    });
});