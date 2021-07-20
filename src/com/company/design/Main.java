package com.company.design;

import com.company.design.adapter.*;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
        //1.싱글톤
//        Aclazz aclazz =new Aclazz();
//        Bclazz bclazz =new Bclazz();
//
//        SocketClient aClient=aclazz.getSocketClient();
//        SocketClient bClient=bclazz.getSocketClient();
//
//        System.out.println("두개의 객체가 동일한가?");
//        System.out.println(aClient.equals(bClient));

        //2.어댑터
       /* HairDryer hairDryer=new HairDryer();
        connect(hairDryer);

        Cleaner cleaner=new Cleaner();
//      connect(cleaner); 문제있다
        Electronic110V adapter=new SocketAdapter(cleaner);
        connect(adapter); //클리너를 바로 연결이아니라 어댑터를 통해..오진다다


       AirConditioner airConditioner= new AirConditioner();
       Electronic110V airAdapter =new SocketAdapter(airConditioner);
       connect(airAdapter); //어댑터를 넣어주기!!*/

        //3.프록시
//        Browser browser=new Browser("www.naver.com");
//        browser.show(); //browser loading html from = www.naver.com
//        browser.show(); //browser loading html from = www.naver.com
//        browser.show(); //browser loading html from = www.naver.com
//        browser.show(); //browser loading html from = www.naver.com

        IBrowser browser=new BrowserProxy("www.naver.com");
        browser.show(); //BrowserProxy loading html from = www.naver.com
        browser.show(); //BrowserProxy use cache html = www.naver.com
        browser.show(); //BrowserProxy use cache html = www.naver.com
        browser.show(); //BrowserProxy use cache html = www.naver.com
        browser.show(); //BrowserProxy use cache html = www.naver.com

}
    /*//콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }*/
}
