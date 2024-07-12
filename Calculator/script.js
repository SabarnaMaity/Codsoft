function add(x){
    document.getElementById("out").value += x; 
}
function cal(){
    var output = document.getElementById("out").value;
    var result = eval(output);
    document.getElementById("out").value = result;
    document.getElementById("out").value = result;
}