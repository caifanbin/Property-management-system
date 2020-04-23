document.getElementsByClassName = function(cl) {
		var retnode = [];
		var myclass = new RegExp('\\b'+cl+'\\b');
		var elem = this.getElementsByTagName('*');
		for (var j = 0; j < elem.length; j++) {
			var classes = elem[j].className;
			if (myclass.test(classes)) retnode.push(elem[j]);
		}
		return retnode;
	}
function HideAll(serial) {
		var items = document.getElementsByClassName("optiton");
		for (var j=0; j<items.length; j++) {
			items[j].style.display = "none";
		}
		if(Number(serial)>-1){
		   document.getElementById("opt_" + serial).style.display = "block";
		}
}
function furl(i) {
		var items = document.getElementsByClassName("title");
		var state = document.getElementById("opt_" + i).style.display;
		HideAll(-1);
		for (var j=0; j<items.length; j++) {	    
		    if(j==i){
		       var o = document.getElementById("opt_" + j);
		       if (state == "block") {
		         o.style.display = "none";
		       }else{
		          o.style.display = "block";
		       }
		    }
		}
	}