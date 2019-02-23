package com.pijiuji.util;

public class Param {

    public static final String PATH = "http://cxmeng.natapp1.cc/uploadimg/";
//    public static final String address = "http://xiaorongrong.natapp1.cc";
    public static final String address = "http://www.munihei.net";
//    public static final String address = "http://cxmeng.natapp1.cc";
//    //微信全局参数
//    /**
//     * 微信公众号参数
//     *///  wx6669854ed8bdce01
//    public static final String APPID = "wx9c84460d088e70a1";
//    //  62ec6e4d3024ede1f699b380762e7d4b
//    public static final String APPSECRET = "64d75ba7033c2bc9095eee232bbb6bb8";
//    //1500226672
//    public static final String mch_id = "1505502821";
//    public static final String SIGN_TYPE = "MD5";
//    //2933611669mengqinglong1234567890
//    public static final String key = "2933611669mengqinglong1234567890";
//
//    public static final String NOTIFY_URL  = "http://cxmeng.natapp1.cc";
    //微信全局参数
    /**
     * 微信公众号参数
     *///  wx6669854ed8bdce01
    public static final String APPID = "wx6669854ed8bdce01";
    //  62ec6e4d3024ede1f699b380762e7d4b
    public static final String APPSECRET = "65401626e586fa4a1860109cb73df8fa";
    //1500226672
    public static final String mch_id = "1500226672";
    public static final String SIGN_TYPE = "MD5";
    //2933611669mengqinglong1234567890
    public static final String key = "pixiaoshengmenghaozhao0123456789";

    public static final String NOTIFY_URL  = address+"/weixin/notifyOrder";

    public static final Double Money  = 0.05;


    public static final String ALIPAYNOTIFYURL = address+"/Alipay/notify";

    public static final String PUBLICKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiwk9XJCj7ICdY2+p8N3w0dkhcVmZ5FyVQ0T22BScoDNiqnHBdPcqzH0/cjIcG37GlsFyrnbidSTtw22y6qEqVE5grcXLJtJgNU4WVAxFkCngL3AMn9UVImEFgcHfCbVZnGl/P1jz7Et/ThZsFrKxhnTc0j8iun6Gua8M66ND2HarA2uCMx1JVvFjGOwVwG04vtI6//h9uoSWSl0X7oKmqxOeVCP+uqZ+bqdIO9VPrmtDgjOrRQ8uI6XhiZEe7OImf536S7YJVy/q9O9/xZD2J6/ogfkgBT2zCWmYHZswu7moZHD655vAgXrPMjuk3p0v771veAjHi0VW2aF/ssTV/QIDAQAB";

    public static final String PRIVATEKAY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCZ7ydvLLrNfRTJpyIrxymQ4ahz2Um4HjbmvPbggd26brnNhmO4BykyA+nwj4IjE7i6s7Z61YxNk8iVrzVF3dWLO/uMhW2U/CxmzAhWCRm2R3SBfJtgQXC2ILvhPoerrXweZ+uEd+v70DB5Gu26BaYK2iUWbzkv0B1PnqlPU0NRG8ujPydMxvSuTp/PpxstjlNHL8txwDMaX6PDJWPHoWHM4/7IYKJEAPgcxCBYBRcJzYxJgQ7U3ioNkgDeyshD2sAvCWBk1wadj+3inwWz/hBsJCD7Hl+w57HHFAlHnDCICMTs25Dn9nftdft/ipPePR39s+O75idLLgGs7ZNSdSXAgMBAAECggEAdyw+Xxi3meSw59x9aRw+3mMPgoh6NFEnoem1uYDXOYDYYbw7FysQgjait/j3n/A5l35mkxhSqJ6tKwCBiWvsj0B59ACpfvqvGGBuV8qpWaRJcEonBpPGpA4heqrXuXqIor9DglyrQ6kuUQNivMDVBTOGWyy3R4TQb1Ut2BxxchEt9T+giyvKOpho85RTq/x8+/MavwtioDnhz36EWreTznhPOEOO8LfIHYjdvBrjQuUwWLk4cdInp+AD7JGEWlUsIJHZTMBtCRoBQP0Q/KMz4ppejO2d6mWkM8zIY5SEBTSFLfx8giJnh63y3J9mhxdYweNN4Up+XqSdh1aOdw5TAQKBgQDAVvsjnA3sj6outd6Ira+T7dePVUP/p/RfB7VPUjGKRNG7mTVnNaY+0lwndu7S/GrszT1uecEyLap4Goun+ULWrSYpwpkBcYcxQ7LzOcHQBwfwYoHVTAcua1RZQ6DWgeT3iFZ5ErqCOWLN6V3AnRj3EohqHtFg/zW8Zl03Yr3zoQKBgQCtkQTWYGkods0r6aq6TuIWZsaRnejhh+lB436mgidOooDjcWIzwcP45+x+o6ZhPGkGfzTaB8Mq7RDzZtXCd8qjCjq58aW7M98psWrAk6e5YPKEBnzFBnSiuK8024UPCUKzKu0p/mlputoh26bG2Z9npstj5Yqq85fVvRQMIlldNwKBgDTObKrtKGF/XADxC8TIssDRdvIyPbYOHaiNjDjX3yQQGuj/ekr4zsjGpmhrXcxtYsna23feU618HiZVW2xlofUgmq6yb6GW0sAyzwm6HL0JgSN9WBoAgqQ68XCEgb8C8KMJOnyJKM2iBb90x7mfKACFhRBln6SazN0J2aPgJzihAoGAPaQSLryAvEEs7pqG6rHXM5N+k/qb2XT2T1MnCKWSpieqVJxQ/waivcRIRlWCYmgc+JS2xXQaSSV2bqsn4W+/xJV+c8kxTcHHULxUqF4IJBsdJexT5Xk8dQnYF5Kat9NXH+Bv6AkVkNouW/XxTg+9wAcJlsnPrJTkaKFE/GY6jJMCgYEAv2tEgnGfde6TYYVjElHWHKSwZDohJXzgwSQyJ1vQbqCw4DbzhZgJQWf28Otl64GgFKSVC27gQcxmbf4DK3U4yzQ9jJBuaurPZa2ADoTIxyUn9viHuw/MoZZ2hlQX/hgAazIAfviPa9jSy3WrnGp8dT5KbIMbVpLSWPNbJoNEbyM=";


    public static final String ALIPAYAPPID ="2019011162897192";

    public static final String PAYWAYURL = "https://openapi.alipay.com/gateway.do";

    public static final Integer pageSize = 10;

}
