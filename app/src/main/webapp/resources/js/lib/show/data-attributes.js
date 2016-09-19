$(function() {
  setTimeout(function(){
	  var img = $('img[data-large-img]');
	  var src = $(img).attr('data-large-img');
	  console.log(src);
	  $(img).attr('data-zoom-image', src);
  }, 400);
});  