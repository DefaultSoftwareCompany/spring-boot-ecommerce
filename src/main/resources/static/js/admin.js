$(document).ready(function () {
    $(".add-category").click(function (e) {
        e.preventDefault();
        text = "<tr>" +
            "<td><input type='text' placeholder='Category Name'></td>" +
            "<td><textarea placeholder='Category Description'></textarea></td>" +
            "<td><input type='file'></td>" +
            "<td colspan='2'><a href='#' class='new-category'>Save</a></td>" +
            "</tr>"
        $("tbody").append(text);
        $(this).remove();
    });
    $("a.new-category").click(function (e) {
        e.preventDefault();
        // text = "";
        // $("tbody").append("<h1>Hello World!</h1>");
        // $("tfoot").append("" +
        //     "<td colspan='5' class='add-category'>Add New Category</td>" +
        //     "")
        console.log(e);
    });
});