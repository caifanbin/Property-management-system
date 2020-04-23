function setday(tt,obj,formname){
  var n=window.location.pathname.lastIndexOf('/');
  var s=""
  if(n>0)
    s=window.location.pathname.substr(0,n);
  s=s+"/";
//  alert(s);
//  var p="dialogTop:"+tt.offsetTop+";dialogLeft:"+tt.offsetLeft+";";
  var ret=showModalDialog("scripts/rl.htm", obj.value ,"dialogWidth:286px;dialogHeight:221px;status:no;help:no;");  
  if(ret!=null&&ret!=""&&ret!="undefined")
  	obj.value=ret;
}
