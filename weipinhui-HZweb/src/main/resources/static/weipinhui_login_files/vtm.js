VTM = window.VTM||{};
VTM.protocol = (("https:" == document.location.protocol) ? "https://" : "http://");


function other_loadjs(url) {
	var script = document.createElement('script');
	script.type = 'text/javascript'; script.async = true;
	script.src = VTM.protocol+url.replace('http:\/\/','');
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(script, s);
}

/** ------ 执行第三方统计代码 ------**/

	    function admaster(url){if("101"==VTM.pageId||"102"==VTM.pageId){return}var _smq=_smq||[];_smq.push(["_setAccount","6230a49",new Date()]);_smq.push(["_setHeatmapEnabled","no"]);_smq.push(["_setDomainName","vip.com"]);_smq.push(["pageview"]);window._smq=_smq;new Image().src=VTM.protocol+"v.admaster.com.cn/i/a58434,b715772,c2,i0,m202,h";other_loadjs(url)};
	    function mediavPcTracker(url){var _mvq=window._mvq||[];_mvq.push(["$setAccount","m-120-0"]);_mvq.push(["$logConversion"]);window._mvq=_mvq;if(window.VTM&&"503"==VTM.pageId){var randomOrderId=Math.random().toString().slice(2,18)+(new Date).getTime();_mvq.push(["$setGeneral","ordercreate","","",""]);_mvq.push(["$addOrder",randomOrderId,""]);_mvq.push(["$addItem",randomOrderId,"12345","12345","","","",""])}other_loadjs(url);if(window.VTM&&"218"==VTM.pageId){$.Listeners.sub("stock_status").onsuccess(function(data){var stock_status=data.total?1:0;_mvq.push(["$setGeneral","goodsdetail","","",""]);var imgUrls=[];for(i=0;i<VTM.pageData.goods.imgUrls.length;++i){imgUrls.push(VTM.protocol+VTM.pageData.goods.imgUrls[i].replace("//",""))}var logoImgUrl=VTM.pageData.goods.brand.logoImgUrl;var brandLogoImgUrl=(logoImgUrl!=undefined&&logoImgUrl!="")?VTM.protocol+logoImgUrl.replace("//",""):"";_mvq.push(["$addGoods",VTM.pageData.goods.category.id,VTM.pageData.goods.brand.id,VTM.pageData.goods.name,VTM.pageData.goods.id,VTM.pageData.goods.currentPrice,imgUrls,VTM.pageData.goods.category.name,VTM.pageData.goods.brand.name,stock_status,VTM.pageData.goods.price,VTM.pageData.goods.favoriteNumber,VTM.pageData.goods.underShelfTime]);_mvq.push(["$addPricing",brandLogoImgUrl]);_mvq.push(["$logData"])})}var userTag=mediavGetNewOldUserTag();if(userTag==0||userTag==1){var mediav_img=new Image(1,1);mediav_img.onload=mediav_img.onerror=mediav_img.onabort=function(){mediav_img.onload=mediav_img.onerror=mediav_img.onabort=null;mediav_img=null};mediav_img.src=(VTM.protocol+(userTag==0?"mvp.mediav.com/t?type=3&db=none&jzqs=m-120-0&jzqv=3.2.7.12&qzjtag=86602588":"mvp.mediav.com/t?type=3&db=none&jzqs=m-120-0&jzqv=3.2.7.12&qzjtag=62308771"))}window._mvq=_mvq}function mediavGetNewOldUserTag(){var cookies=document.cookie.split(";");var hasLogin=0,userTag=3;for(var i=0;i<cookies.length;++i){var singleCookie=cookies[i].split("=");if(singleCookie[0].replace(/(^\s*)|(\s*$)/g,"")=="VipUINFO"){var luc=unescape(singleCookie[1]).match("luc:[abcABC]");if(luc!=null){var status=luc[0].split(":")[1];userTag=(status=="c"?0:1)}}if(singleCookie[0].replace(/(^\s*)|(\s*$)/g,"")=="VipRNAME"||singleCookie[0].replace(/(^\s*)|(\s*$)/g,"")=="login_username"){hasLogin=1;if(userTag!=3){break}}}if(userTag==1&&hasLogin==0){userTag=3}return userTag};
function startDsp(){
            admaster('http://ms.vipstatic.com/vtm/vtm_config_res/prod/1478073304370_js_core.js');
            mediavPcTracker('http://ms.vipstatic.com/vtm/vtm_config_res/prod/1479787994830_js_core.js');
    }
function startNotDsp(){
    }
function startVtm(){
    /**cart**/
    if('501'==VTM.pageId) return;
    startDsp();
    startNotDsp();
}

startVtm();

$.Listeners && $.Listeners.pub('vtm.loaded').success();


