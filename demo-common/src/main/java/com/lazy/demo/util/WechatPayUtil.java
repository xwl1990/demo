package com.lazy.demo.util;

import java.util.Map;
import java.util.TreeMap;

import com.lazy.demo.cst.WechatPayCst;
import com.lazy.demo.model.WeixinBaseParam;
import com.lazy.demo.model.WeixinMicroReverseRespParam;
import com.lazy.demo.model.WeixinQueryStatusRespParam;
import com.lazy.demo.model.WeixinUnifiedOrderRespParam;

/**
 * Description: Call微信
 *
 * @author: xieweili
 * @since: 2016年12月31日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class WechatPayUtil {

    /**
     * 微信支付下单
     * 
     * @param wuop
     * @return
     * @throws Exception
     */
    public static WeixinMicroReverseRespParam unifiedorder(WeixinUnifiedOrderRespParam p) throws Exception {
        p.setAppid(WechatPayCst.APP_ID);
        p.setBody("1");
        p.setMch_id(WechatPayCst.MCHT_ID);
        p.setSign_type("MD5");
        p.setNotify_url("http://www.baiduc.om");
        // p.setDevice_info("WEB");
        p.setTrade_type("NATIVE");//
        // p.setSign(createSgin(p));
        String data = WeixinXmlUtils.convertMapToXML(signAndConvertToMap(p, WechatPayCst.APP_KEY));
        // FreemarkerUtils.getContentByFileName("wechat_pay.ftl",
        // MapperUtils.beanToMap(p));
        System.out.println(data);
        data = OkHttpUtils.httpClientJsonPostReturnAsString(WechatPayCst.WECHAT_PAY_UNIFIEDORDER_URL, data, WechatPayCst.WECHAT_TIMEOUT);
        System.out.println("\r");
        System.out.println(data);
        return WeixinXmlUtils.parseReverse(data);
    }

    /***
     * 查询微信下单状态
     * 
     * @param wqsp
     * @return
     * @throws Exception
     */
    public static WeixinQueryStatusRespParam orderquery(WeixinQueryStatusRespParam p) throws Exception {
        p.setAppid(WechatPayCst.APP_ID);
        p.setMch_id(WechatPayCst.MCHT_ID);
        String q = WeixinXmlUtils.convertMapToXML(signAndConvertToMap(p, WechatPayCst.APP_KEY));
        System.out.println(q);
        q = OkHttpUtils.httpClientJsonPostReturnAsString(WechatPayCst.WECHAT_PAY_ORDER_QUERY_URL, q, WechatPayCst.WECHAT_TIMEOUT);
        System.out.println("\r" + q);
        return WeixinXmlUtils.parseQueryStatus(q);
    }

    public static Map<String, Object> signAndConvertToMap(Object object, String signKey) {
        Map<String, Object> beanMap = MapperUtils.beanToMap(object);

        TreeMap<String, Object> treeMap = new TreeMap<String, Object>(beanMap);
        if (treeMap.containsKey("sign")) {
            treeMap.remove("sign");
        }
        if (treeMap.containsKey("class")) {
            treeMap.remove("class");
        }
        if (treeMap.containsKey("appCode")) {
            treeMap.remove("appCode");
        }
        if (treeMap.containsKey("mchtNo")) {
            treeMap.remove("mchtNo");
        }
        StringBuffer sb = new StringBuffer();
        String key = treeMap.firstKey();
        sb.append(key).append("=").append(treeMap.get(key));
        while ((key = treeMap.higherKey(key)) != null) {
            if (treeMap.get(key) != null) {
                sb.append("&").append(key).append("=").append(treeMap.get(key));
            }
        }
        String sign = SignatureUtils.sign(sb.toString(), SignatureUtils.SIGNATURE_MD5, "&key=" + signKey);
        System.out.println(sign);
        treeMap.put("sign", sign);
        return treeMap;
    }

    /***
     * 签名
     * 
     * @param wpo
     * @return
     */
    public static String createSgin(WeixinBaseParam p) {
        StringBuffer sb = new StringBuffer();
        Map<String, Object> map = new TreeMap<String, Object>(MapperUtils.beanToMap(p));
        for (String key : map.keySet()) {
            sb.append("&" + key + "=" + map.get(key));
        }
        String data = sb.toString().substring(1) + "&key=" + WechatPayCst.APP_KEY;
        System.out.println(data);
        data = CryptUtils.encryptToMD5(data.getBytes());
        System.out.println(data.toUpperCase());
        return data.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        WeixinQueryStatusRespParam wbp = new WeixinQueryStatusRespParam();
        wbp.setNonce_str(StringTool.getUUID());
        wbp.setOut_trade_no(StringTool.getOrderID());
        // orderquery(wbp);

        WeixinUnifiedOrderRespParam wpo = new WeixinUnifiedOrderRespParam();
        String id = StringTool.getUUID();
        wpo.setNonce_str(id);
        wpo.setOut_trade_no(id);
        wpo.setTotal_fee("66");
        wpo.setSpbill_create_ip("123.12.12.123");
        unifiedorder(wpo);

    }
}
