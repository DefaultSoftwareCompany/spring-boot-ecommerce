$(document).ready(function () {
    $(".add-to-cart").click(function (e) {
        e.preventDefault();
        if ($(this).text() === "Add To Cart") {
            $(".nav-item .badge").text(parseInt($(".nav-item .badge").text()) + 1);
            $(this).text("Remove From Cart");
        } else {
            $(".nav-item .badge").text(parseInt($(".nav-item .badge").text()) - 1);
            $(this).text("Add To Cart");
        }
    });
});