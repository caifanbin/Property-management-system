function MakeMenu()
{
	// 考虑将来扩展到frame任意定位菜单，需要指定document和document.body
	var menuDoc=document;
	var menuBody=document.body;
	var menuDiv=$("#page",menuBody);
	
	if(menuDiv.length==0)
	{
		menuDiv=$("<div id='page'><div id='coolMenu-panel' class='grid-c2'><div class='box-diamond' id='coolMenu-menu'><div class='coolMenu-bd' id='menuPad'></div></div></div></div>");
		$(menuBody).append(menuDiv);
	}
}

function AddMenu(selfMenuID,selfMenuText,selfMenusrc,parentMenuID,srcTarget)
{
	// 考虑将来扩展到frame任意定位菜单，需要指定document和document.body
	var menuDoc=document;
	var menuBody=document.body;
	
	var menuPad=$("#menuPad",menuBody);
	if(menuPad.length==0)
	{
		MakeMenu();
		menuPad=$("#menuPad",menuBody);
	}

	var strInnerMenu; // 拼接菜单的html串
	var parentMenu=$("\"#menu_"+parentMenuID+"\"",menuBody);
	if(parentMenu.length==0)  // 一级菜单
	{
		strInnerMenu="<div class='menu-box' id='menu_"+selfMenuID+"'><h3 class='coolMenu-bar'><span>"+selfMenuText+"</span><button class='menu-close'>-</button></h3></div>";
		menuPad.append(strInnerMenu);
	}
	else if(parentMenu.attr("class")=="menu-box")  // 二级菜单
	{
		strInnerMenu="<li id='menu_"+selfMenuID+"'><span><a href='"+selfMenusrc+"' target='"+srcTarget+"'>"+selfMenuText+"</a></span></li>";
		var S_ul=$("\"#ul_"+parentMenuID+"\"",menuBody);
		if(S_ul.length==0)
		{
			S_ul=$("<ul class='group' id='ul_"+parentMenuID+"'></ul>");
			parentMenu.append(S_ul);	
		}
		S_ul.append(strInnerMenu);
	}
	else  // 三级以下菜单
	{
		strInnerMenu="<li id='menu_"+selfMenuID+"'><a href='"+selfMenusrc+"' target='"+srcTarget+"'>"+selfMenuText+"</a></li>";
		var T_ul=$("\"#ul_"+parentMenuID+"\"",menuBody);
		if(T_ul.length==0)
		{
			T_ul=$("<ul id='ul_"+parentMenuID+"'></ul>");
			parentMenu.append(T_ul);	
			parentMenu.addClass("fold-close");
			parentMenu.find("span:first").attr("id","T_span");
		}
		T_ul.append(strInnerMenu);
	}	

}

function BindEclipseFun()
{

	$("span[id='T_span']").toggle(
		function() 
		{
		    $(this).parents("li").removeClass("fold-close").addClass("fold-open");
		},
	    function() 
	    {
	        $(this).parents("li").removeClass("fold-open").addClass("fold-close");
	    }
	);

    $("h3[class='coolMenu-bar']").toggle(
    	function() 
	    {	
	        $(this).next("ul:first").addClass("hidden");
	        $(this).find("button").removeClass("menu-close").addClass("menu-open");
	    },
	    function() 
	    {
	        $(this).next("ul:first").removeClass("hidden");
	        $(this).find("button").removeClass("menu-open").addClass("menu-close");
    	}
    );	

}