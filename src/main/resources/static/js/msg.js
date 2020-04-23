function CLASS_MSN_MESSAGE(id, width, height, caption, title, message, target, action) {
	this.id = id;
	this.title = title;
	this.caption = caption;
	this.message = message;
	this.target = target;
	this.action = action;
	this.width = width ? width : 200;
	this.height = height ? height : 120;
	this.timeout = 500;
	this.speed = 2;
	this.step = 1;
	this.right = screen.width - 1;
	this.bottom = screen.height;
	this.left = this.right - this.width;
	this.top = this.bottom - this.height;
	this.timer = 0;
	this.pause = false;
	this.close = false;
	this.autoHide = true;
	this.canclose=true;
}

CLASS_MSN_MESSAGE.prototype.hide = function () {
	if (this.onunload()) {
		var offset = this.height > this.bottom - this.top ? this.height : this.bottom - this.top;
		var me = this;
		if (this.timer > 0) {
			window.clearInterval(me.timer);
		}
		var fun = function () {
			if (me.pause == false || me.close) {
				var x = me.left;
				var y = 0;
				var width = me.width;
				var height = 0;
				if (me.offset > 0) {
					height = me.offset;
				}
				y = me.bottom - height;
				if (y >= me.bottom) {
					window.clearInterval(me.timer);
					me.Pop.hide();
				} else {
					me.offset = me.offset - me.step;
				}
				me.Pop.show(x, y, width, height);
			}
		};
		this.timer = window.setInterval(fun, this.speed);
	}
};
CLASS_MSN_MESSAGE.prototype.onunload = function () {
	return true;
};

CLASS_MSN_MESSAGE.prototype.oncommand = function (type) {
	if (type == "A1") {
		top.location.href = "./AppEmailRev.do?action=inital";
	} else if (type == "A2") {
		top.location.href = "./memo.do?action=bw";
	} else {
			top.location.href = this.action;
	}

	this.close = true;   
          //this.hide();       
};

CLASS_MSN_MESSAGE.prototype.show = function () {
	var oPopup = window.createPopup();   //IE5.5+       
	this.Pop = oPopup;
	var w = this.width;
	var h = this.height;
	var str = "<DIV id='eMsg' style='Z-INDEX:-1000;LEFT:0px;WIDTH:" + w + "px;POSITION:absolute;TOP:0px;HEIGHT:" + h + "px;'>";
	str += "<TABLE cellSpacing=0 cellPadding=0 width='200px' height='150px' border=0 background='./images/dbsxbg.gif'>";
	str += "<TR>";
	str += "<TD style='FONT-SIZE: 12px;COLOR: #0f2c8c' width=30 height=24></TD>";
	str += "<TD style='PADDING-LEFT: 4px; FONT-WEIGHT: normal; FONT-SIZE: 12px; COLOR: #1f336b; PADDING-TOP: 4px;' vAlign=center width='100%'>" + this.caption + "</TD>";
	str += "<TD style='PADDING-RIGHT: 6px; PADDING-TOP: 2px' vAlign=center align=right width=19>";
	str += "<SPAN style='FONT-WEIGHT: bold; FONT-SIZE:12px; CURSOR: hand; COLOR: red; MARGIN-RIGHT: 4px' id='btSysClose'><img src='./images/close.gif' align='absmiddle' border='0'></SPAN></TD>";
	str += "</TR>";
	str += "<TR>";
	str += "<TD style='PADDING-RIGHT: 1px;PADDING-BOTTOM: 1px;' align='center' colSpan=3 height=" + (h - 28) + ">";
	str += "<DIV style='BORDER-RIGHT: #b9c9ef 0px solid;PADDING-RIGHT:   8px;   BORDER-TOP:   #728eb8 0px solid; PADDING-LEFT: 8px; FONT-SIZE: 12px; PADDING-BOTTOM: 8px; BORDER-LEFT: #728eb8 0px solid; WIDTH: 100%; COLOR: #1f336b; PADDING-TOP: 8px; BORDER-BOTTOM: #b9c9ef 0px solid; HEIGHT: 100%'>" + this.title + "<BR>";
	str += "<DIV style='WORD-BREAK:break-all;margin-left:30px;' align=left>" + this.message + "</DIV>";
	str += "</DIV>";
	str += "</TD>";
	str += "</TR>";
	str += "</TABLE>";
	str += "</DIV>";
	oPopup.document.body.innerHTML = str;
	this.offset = 0;
	var me = this;
	oPopup.document.body.onmouseover = function () {
		me.pause = true;
	};
	oPopup.document.body.onmouseout = function () {
		me.pause = false;
	};
	
	me.canclose=!me.canclose;
	var fun = function () {
		var x = me.left;
		var y = 0;
		var width = me.width;
		var height = me.height;
		if (me.offset > me.height) {
			height = me.height;
		} else {
			height = me.offset;
		}
		y = me.bottom - me.offset;
		if (y <= me.top) {
			me.timeout--;
			if (me.timeout == 0) {
				window.clearInterval(me.timer);
				if (me.autoHide) {
					me.hide();
					me.canclose=true;
				}
			}
		} else {
			me.offset = me.offset + me.step;
		}
		me.Pop.show(x, y, width, height);
	};
	this.timer = window.setInterval(fun, this.speed);
	var btClose = oPopup.document.getElementById("btSysClose");
	btClose.onclick = function () {
		me.close = true;
		me.hide();
		me.canclose=true;
	};      

	var itemType = oPopup.document.getElementById("itemType").value;   //办件类型
	
	
	if (itemType.indexOf("Z1") >= 0 && itemType.substring(itemType.indexOf("Z1")+2,itemType.indexOf("Z1")+3)==",") {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z1");
		btCommand.onclick = function () {
			me.oncommand("Z1");
		};
	}
	if (itemType.indexOf("Z2") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z2");
		btCommand.onclick = function () {
			me.oncommand("Z2");
		};
	}
	if (itemType.indexOf("Z4") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z4");
		btCommand.onclick = function () {
			me.oncommand("Z4");
		};
	}
	if (itemType.indexOf("Z5") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z5");
		btCommand.onclick = function () {
			me.oncommand("Z5");
		};
	}
	if (itemType.indexOf("P6") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "P6");
		btCommand.onclick = function () {
			me.oncommand("P6");
		};
	}
	if (itemType.indexOf("Z7") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z7");
		btCommand.onclick = function () {
			me.oncommand("Z7");
		};
	}
	if (itemType.indexOf("Z10") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z10");
		btCommand.onclick = function () {
			me.oncommand("Z10");
		};
	}
	if (itemType.indexOf("Z3") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z3");
		btCommand.onclick = function () {
			me.oncommand("Z3");
		};
	}
	
	if (itemType.indexOf("Z8") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z8");
		btCommand.onclick = function () {
			me.oncommand("Z8");
		};
	}
	
	if (itemType.indexOf("Z9") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z9");
		btCommand.onclick = function () {
			me.oncommand("Z9");
		};
	}
	
	if (itemType.indexOf("Z11") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "Z11");
		btCommand.onclick = function () {
			me.oncommand("Z11");
		};
	}
	
	if (itemType.indexOf("A1") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A1");
		btCommand.onclick = function () {
			me.oncommand('A1');
		};
	}
	if (itemType.indexOf("A2") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A2");
		btCommand.onclick = function () {
			me.oncommand('A2');
		};
	}
	if (itemType.indexOf("A3") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A3");
		btCommand.onclick = function () {
			me.oncommand('A3');
		};
	}
	if (itemType.indexOf("A4") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A4");
		btCommand.onclick = function () {
			me.oncommand('A4');
		};
	}
	
	if (itemType.indexOf("A5") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A5");
		btCommand.onclick = function () {
			me.oncommand('A5');
		};
	}
	if (itemType.indexOf("A6") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A6");
		btCommand.onclick = function () {
			me.oncommand('A6');
		};
	}
	if (itemType.indexOf("A7") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A7");
		btCommand.onclick = function () {
			me.oncommand('A7');
		};
	}
	if (itemType.indexOf("A8") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A8");
		btCommand.onclick = function () {
			me.oncommand('A8');
		};
	}
	
	if (itemType.indexOf("A9") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A9");
		btCommand.onclick = function () {
			me.oncommand('A9');
		};
	}
	if (itemType.indexOf("A10") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommand" + "A10");
		btCommand.onclick = function () {
			me.oncommand('A10');
		};
	}
	
	if (itemType.indexOf("X1") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommandX1");
		btCommand.onclick = function () {
			me.oncommand('X1');
		};
	}
	if (itemType.indexOf("X2") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommandX2");
		btCommand.onclick = function () {
			me.oncommand('X2');
		};
	}
	
	if (itemType.indexOf("X3") >= 0) {
		var btCommand = oPopup.document.getElementById("btCommandX3");
		btCommand.onclick = function () {
			me.oncommand('X3');
		};
	}
	
	
	var btCommand = oPopup.document.getElementById("btCommand");
	if (btCommand != null) {
		btCommand.onclick = function () {
			me.oncommand(0);
		};
	}
};
/**/
/*     
  **   设置速度方法     
  **/
CLASS_MSN_MESSAGE.prototype.speed = function (s) {
	var t = 20;
	try {
		t = praseInt(s);
	}
	catch (e) {
	}
	this.speed = t;
};
/**/
/*     
  **   设置步长方法     
  **/
CLASS_MSN_MESSAGE.prototype.step = function (s) {
	var t = 1;
	try {
		t = praseInt(s);
	}
	catch (e) {
	}
	this.step = t;
};
CLASS_MSN_MESSAGE.prototype.rect = function (left, right, top, bottom) {
	try {
		this.left = left != null ? left : this.right - this.width;
		this.right = right != null ? right : this.left + this.width;
		this.bottom = bottom != null ? (bottom > screen.height ? screen.height : bottom) : screen.height;
		this.top = top != null ? top : this.bottom - this.height;
	}
	catch (e) {
	}
};

