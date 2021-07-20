package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

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

//        IBrowser browser=new BrowserProxy("www.naver.com");
//        browser.show(); //BrowserProxy loading html from = www.naver.com
//        browser.show(); //BrowserProxy use cache html = www.naver.com
//        browser.show(); //BrowserProxy use cache html = www.naver.com
//        browser.show(); //BrowserProxy use cache html = www.naver.com
//        browser.show(); //BrowserProxy use cache html = www.naver.com

        /*//시간체크
        AtomicLong start =new AtomicLong();
        AtomicLong end=new AtomicLong();

        IBrowser aopBrowser =new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis()); //현재시간 셋팅
                },
                ()->{
                    long now=System.currentTimeMillis(); //현재시간
                    end.set(now-start.get()); //총걸린시간

                }
                    );
                aopBrowser.show();
                System.out.println("loading time:"+end.get()); //loading time:1525

                aopBrowser.show();
                System.out.println("loading time:"+end.get()); //loading time:0*/

        //4.데코레이터
        /*ICar audi =new Audi(1000);
        audi.showPrice();;

        //a3
        ICar audi3 =new A3(audi,"A3");
        audi3.showPrice();
        //a4
        ICar audi4 =new A4(audi,"A4");
        audi4.showPrice();
        //a5
        ICar audi5 =new A5(audi,"A5");
        audi5.showPrice();*/

        /*//5.옵저버 패턴
        Button button=new Button("버튼");
        button.addListener(new IButtonListener() { //익명
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지전달: click1");
        button.click("메시지전달: click2");
        button.click("메시지전달: click3");
        button.click("메시지전달: click4");*/

        //6.파사드 패턴
//        Ftp ftpClient =new Ftp("www.foo.co.kr",22,"/home/etc");
//        ftpClient.connect();
//        ftpClient.moveDirectory();
//
//        Writer writer=new Writer("text.tmp");
//        writer.fileConnect();
//        writer.fileWrite();
//
//        Reader reader=new Reader("text.tmp");
//        reader.fileConnect();
//        reader.fileRead();
//
//        //종료
//        reader.fileDisconnect();
//        writer.fileDisconnect();
//        ftpClient.disConnect();

        /*SftpClient sftpClient=new SftpClient("www.foo.co.kr",22,"/home/etc","text.temp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disconnect(); //오 이걸로 한방에 끝이라고..*/


        //7.전략
        Encoder encoder=new Encoder();

        //base64
        EncodingStrategy base64= new Base64Strategy();

        //normal
        EncodingStrategy normal=new NormalStrategy();

        String message="hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result=encoder.getMessage(message);
        System.out.println(base64Result);//aGVsbG8gamF2YQ==


        encoder.setEncodingStrategy(normal);
        String normalResult=encoder.getMessage(message);
        System.out.println(normalResult);//hello java

        //+
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult=encoder.getMessage(message);
        System.out.println(appendResult);
}

    /*//콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }*/
}
