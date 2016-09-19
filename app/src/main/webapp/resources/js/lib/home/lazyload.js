$(function() {
    $("img.lazy").show().lazyload({
    	effect : "fadeIn",
    	event : "sporty"
    });
});

$(window).bind("load", function() {
    var timeout = setTimeout(function() {
        $("img.lazy").trigger("sporty")
    }, 600);
});