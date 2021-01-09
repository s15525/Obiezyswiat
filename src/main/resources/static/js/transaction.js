/*
$(document).ready(function () {

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

            $.get(href, function (transaction, status) {
                $('.myForm #id').val(transaction.id);
                $('.myForm #companyName').val(transaction.companyName);
                $('.myForm #bid').val(transaction.bid);
                $('.myForm #route').val(transaction.route);
                $('.myForm #loadingPlace').val(transaction.loadingPlace);
                $('.myForm #unloadingPlace').val(transaction.unloadingPlace);

            });
            $('.myForm #exampleModal').modal();

    });
});*/

$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return Przyjmij or Wiecej info

        if (text === 'Przyjmij') {
            $.get(href, function (employee, status) {
                $('.myForm #id').val(employee.id);
                $('.myForm #employeeFullName').val(employee.firstName);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #employeeFullName').val('');
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (employee, status) {
            $('.myForm #id').val(employee.id);
            $('.myForm #employeeFullName').val(employee.firstName);
        });
        $('.myForm #exampleModal').modal();
        });
});
