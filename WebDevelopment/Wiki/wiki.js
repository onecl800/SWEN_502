 
//event listener to show log in form when button is clicked 
window.addEventListener('load', function() {
    document.getElementById('sgninbtn').addEventListener('click', function(e) {
        var style = document.getElementById('signIn').style;
        style.display = (style.display == 'block') ? 'none' : 'block';
    }, true);
}, true);
     
     


//event listeners to toggle between content (home, skydiving wiki page, discussion board, history)
window.addEventListener('load', function() {
    document.getElementById('homebtn').addEventListener('click', function(e) {
       var style = document.getElementById('home').style;
       style.display = (style.display == 'block') ? 'none' : 'block' ;
    }, true);
}, true);



