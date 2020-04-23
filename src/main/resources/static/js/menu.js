NS6 = (document.getElementById&&!document.all);
IE = (document.all);
NS = (navigator.appName=="Netscape" && navigator.appVersion.charAt(0)=="4");
tempBar='';
barBuilt=0;ssmItems=new Array();
moving=setTimeout('null',1);

function moveOut() {
if ((NS6||NS)&&parseInt(ssm.left)<0 || IE && ssm.pixelLeft<0) {
clearTimeout(moving);
moving = setTimeout('moveOut()', slideSpeed);
slideMenu(10);
}
else {
clearTimeout(moving);moving=setTimeout('null',1);
}
}

function moveBack(){
 clearTimeout(moving);
 moving = setTimeout('moveBack1()', waitTime);
 }
function moveBack1() {
if ((NS6||NS) && parseInt(ssm.left)>(-menuWidth) || IE && ssm.pixelLeft>(-menuWidth)) {
clearTimeout(moving);
moving = setTimeout('moveBack1()', slideSpeed);slideMenu(-10);
}
else {
clearTimeout(moving);moving=setTimeout('null',1);
}
}
function slideMenu(num){
if (IE) {ssm.pixelLeft += num;}
if (NS||NS6) {ssm.left = parseInt(ssm.left)+num;}
if (NS) {bssm.clip.right+=num;bssm2.clip.right+=num;}}
function makeStatic() {
if (NS||NS6) {winY = window.pageYOffset;}
if (IE) {winY = document.body.scrollTop;}
if (NS6||IE||NS) {
if (winY!=lastY&&winY>Yoffset-staticYOffset) {
smooth = .2 * (winY - lastY - Yoffset + staticYOffset);}
else if (Yoffset-staticYOffset+lastY>Yoffset-staticYOffset) {
smooth = .2 * (winY - lastY - (Yoffset-(Yoffset-winY)));}
else {smooth=0}
if(smooth > 0) smooth = Math.ceil(smooth);
else smooth = Math.floor(smooth);
if (IE) bssm.pixelTop+=smooth;
if (NS6||NS) bssm.top=parseInt(bssm.top)+smooth
lastY = lastY+smooth;
setTimeout('makeStatic()', 1)}}
function buildBar() {
if(barText.indexOf('<IMG')>-1) {tempBar=barText}
else{for (b=0;b<barText.length;b++) {tempBar+=barText.charAt(b)+"<BR>"}}
document.write('<td align="center" rowspan="100" width="'+barWidth+'" bgcolor="'+barBGColor+'" valign="'+barVAlign+'"><p align="center"><font face="'+barFontFamily+'" Size="'+barFontSize+'" COLOR="'+barFontColor+'"><B>'+tempBar+'</B></font></p></TD>')}
function initSlide() {
if (NS6){ssm=document.getElementById("thessm").style;bssm=document.getElementById("basessm").style;
bssm.clip="rect(0 "+document.getElementById("thessm").offsetWidth+" "+document.getElementById("thessm").offsetHeight+" 0)";ssm.visibility="visible";}
else if (IE) {ssm=document.all("thessm").style;bssm=document.all("basessm").style
bssm.clip="rect(0 "+thessm.offsetWidth+" "+thessm.offsetHeight+" 0)";bssm.visibility = "visible";}
else if (NS) {bssm=document.layers["basessm1"];
bssm2=bssm.document.layers["basessm2"];ssm=bssm2.document.layers["thessm"];
bssm2.clip.left=0;ssm.visibility = "show";}
if (menuIsStatic=="yes") makeStatic();}
function buildMenu() {
if (IE||NS6) {document.write('<DIV ID="basessm" style="visibility:hidden;Position : Absolute ;Left : '+Xoffset+' ;Top : '+Yoffset+' ;Z-Index : 20;width:'+(menuWidth+barWidth+10)+'"><DIV ID="thessm" style="Position : Absolute ;Left : '+(-menuWidth)+' ;Top : 0 ;Z-Index : 20;" onmouseover="moveOut()" onmouseout="moveBack()">')}
if (NS) {document.write('<LAYER name="basessm1" top="'+Yoffset+'" LEFT='+Xoffset+' visibility="show"><ILAYER name="basessm2"><LAYER visibility="hide" name="thessm" bgcolor="'+menuBGColor+'" left="'+(-menuWidth)+'" onmouseover="moveOut()" onmouseout="moveBack()">')}
if (NS6){document.write('<table border="0" cellpadding="0" cellspacing="0" width="'+(menuWidth+barWidth+2)+'" bgcolor="'+menuBGColor+'"><TR><TD>')}
document.write('<table border="0" cellpadding="0" cellspacing="1" width="'+(menuWidth+barWidth+2)+'" bgcolor="'+menuBGColor+'">');
for(I=0;I<ssmItems.length;I++) {
if(!ssmItems[I][3]){ssmItems[I][3]=menuCols;ssmItems[I][5]=menuWidth-1}
else if(ssmItems[I][3]!=menuCols)ssmItems[I][5]=Math.round(menuWidth*(ssmItems[I][3]/menuCols)-1);
if(ssmItems[I-1]&&ssmItems[I-1][4]!="no"){document.write('<TR>')}
if(!ssmItems[I][1]){
document.write('<td bgcolor="'+hdrBGColor+'" HEIGHT="'+hdrHeight+'" ALIGN="'+hdrAlign+'" VALIGN="'+hdrVAlign+'" WIDTH="'+ssmItems[I][5]+'" COLSPAN="'+ssmItems[I][3]+'"> <font face="'+hdrFontFamily+'" Size="'+hdrFontSize+'" COLOR="'+hdrFontColor+'"><b>'+ssmItems[I][0]+'</b></font></td>')}
else {if(!ssmItems[I][2])ssmItems[I][2]=linkTarget;
document.write('<TD BGCOLOR="'+linkBGColor+'" onmouseover="bgColor=\''+linkOverBGColor+'\'" onmouseout="bgColor=\''+linkBGColor+'\'" WIDTH="'+ssmItems[I][5]+'" COLSPAN="'+ssmItems[I][3]+'"><ILAYER><LAYER onmouseover="bgColor=\''+linkOverBGColor+'\'" onmouseout="bgColor=\''+linkBGColor+'\'" WIDTH="100%" ALIGN="'+linkAlign+'"><DIV  ALIGN="'+linkAlign+'"><FONT face="'+linkFontFamily+'" Size="'+linkFontSize+'"> <A HREF="'+ssmItems[I][1]+'" target="'+ssmItems[I][2]+'" CLASS="ssmItems">'+ssmItems[I][0]+'</DIV></LAYER></ILAYER></TD>')}
if(ssmItems[I][4]!="no"&&barBuilt==0){buildBar();barBuilt=1}
if(ssmItems[I][4]!="no"){document.write('</TR>')}}
document.write('</table>')
if (NS6){document.write('</TD></TR></TABLE>')}
if (IE||NS6) {document.write('</DIV></DIV>')}
if (NS) {document.write('</LAYER></ILAYER></LAYER>')}
theleft=-menuWidth;lastY=0;setTimeout('initSlide();', 1)}
Yoffset=150;
Xoffset=0;
staticYOffset=30;
slideSpeed=20
waitTime=100;
menuBGColor="black";
menuIsStatic="yes";
menuWidth=150;
menuCols=2;
hdrFontFamily="verdana";
hdrFontSize="2";
hdrFontColor="white";
hdrBGColor="#170088";
hdrAlign="left";
hdrVAlign="center";
hdrHeight="15";
linkFontFamily="Verdana";
linkFontSize="2";
linkBGColor="white";
linkOverBGColor="#FFFF99";
linkTarget="_top";
linkAlign="Left";
barBGColor="#444444";
barFontFamily="Verdana";
barFontSize="2";
barFontColor="white";
barVAlign="center";
barWidth=20;
barText="menu"; 

ssmItems[0]=["1", "#", ""]
ssmItems[1]=["2", "#", ""]
ssmItems[2]=["3", "#", ""]
ssmItems[3]=["4", "#", ""]
ssmItems[4]=["5", "#", ""]
buildMenu();