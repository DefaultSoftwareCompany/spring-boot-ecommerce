$(document).ready(function () {
    let sum = 0;
    $(".total").each(function () {
        sum += parseFloat($(this).text());
    });
    $("#sum").text("Total Sum: " + sum);

    $(".increment").click(function (e) {
        e.preventDefault();
        quantity = $(this).prev();
        if (parseInt(quantity.text()) < 5) {
            quantity.text(parseInt(quantity.text()) + 1)
        }
        price = $(this).parent().nextAll().eq(0);
        $(price).next().html(parseFloat($(price).text()) * quantity.text())
        let sum = 0;
        $(".total").each(function () {
            sum += parseFloat($(this).text());
        });
        $("#sum").text("Total Sum: " + sum);
    });
    $(".decrement").click(function (e) {
        e.preventDefault();
        quantity = $(this).next();
        if (parseInt(quantity.text()) > 0) {
            quantity.text(parseInt(quantity.text()) - 1)
        }
        price = $(this).parent().nextAll().eq(0);
        $(price).next().html(parseFloat($(price).text()) * quantity.text())
        let sum = 0;
        $(".total").each(function () {
            sum += parseFloat($(this).text());
        });
        $("#sum").text("Total Sum: " + sum);
    });

    $(".clear").click(function (e) {
        e.preventDefault();
        $("tbody *").remove();
        $("#sum").text("Total Sum: 0")
    });

    $(".remove").click(function (e) {
        e.preventDefault();
        $(this).parent().remove();
        let sum = 0;
        $(".total").each(function () {
            sum += parseFloat($(this).text());
        });
        $("#sum").text("Total Sum: " + sum);
    });
});