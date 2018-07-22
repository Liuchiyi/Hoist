/**
 *
 * @param text
 * @param type
 */
function alertWindow(text, type) {
    swal({
        title: "",
        text: text,
        type: type,
        animation: "slide-from-top",
        allowOutsideClick: false,
        // timer: 4000
    }, function () {
    });
}