DELETE FROM REPAIRTBL
DELETE FROM REPAIRSHOPTBL
DELETE FROM RENTALTBL
DELETE FROM CUSTOMERTBL
DELETE FROM CARTBL
DELETE FROM SHOPTBL
drop table customertbl cascade constraints
drop table cartbl cascade constraints
drop table rentaltbl cascade constraints
drop table shoptbl cascade constraints
drop table repairtbl cascade constraints
drop table repairshoptbl cascade constraints
CREATE TABLE SHOPTBL(  SHOPID varCHAR(6) NOT NULL,SHOPNAME VARCHAR(30) NOT NULL,SHOPADDRESS VARCHAR(45),SHOPMOBILE VARCHAR(20),MANAGER VARCHAR(15),SHOPEMAIL VARCHAR(25),PRIMARY KEY(SHOPID))
INSERT INTO SHOPTBL VALUES('C01','바로캠핑','서울특별시 서대문구 신촌동','02-313-9953','이바로','baro@naver.com')
INSERT INTO SHOPTBL VALUES('C02','러브캠핑','서울특별시 서대문구 대신동','02-363-2433','김러브','love@naver.com')
INSERT INTO SHOPTBL VALUES('C03','드림캠핑','서울특별시 광진구 화양동','02-764-0203','박드림','dream@naver.com')
INSERT INTO SHOPTBL VALUES('C04','블랙캠핑','서울특별시 광진구 능동','02-755-3434','최블랙','black@naver.com')
INSERT INTO SHOPTBL VALUES('C05','썬라이즈캠핑','서울특별시 종로구 효자동','02-635-1112','최이즈','iz@naver.com')
INSERT INTO SHOPTBL VALUES('C06','제이코캠핑','서울특별시 용산구 후암동','02-888-6666','김이코','iko@naver.com')
INSERT INTO SHOPTBL VALUES('C07','에드윈캠핑','서울특별시 중구 무교동','02-969-3468','이드윈','dwin@naver.com')
INSERT INTO SHOPTBL VALUES('C08','포유캠핑','서울특별시 노원구 공릉동','02-698-3462','임포유','foryou@naver.com')
INSERT INTO SHOPTBL VALUES('C09','옵션캠핑','부산광역시 동구 수정동','051-939-2343','이옵션','option@naver.com')
INSERT INTO SHOPTBL VALUES('C10','가족캠핑','부산광역시 동구 좌천동','051-933-2488','김가족','family@naver.com')
INSERT INTO SHOPTBL VALUES('C11','할인캠핑','부산광역시 부산진구 전포동','051-933-1777','김할인','sale@naver.com')
INSERT INTO SHOPTBL VALUES('C12','미국캠핑','강원도 강릉시 홍제동','033-444-2222','박미국','usa@naver.com')
INSERT INTO SHOPTBL VALUES('C13','부산캠핑','강원도 강릉시 명주동','033-443-6777','김부산','busan@naver.com')
INSERT INTO SHOPTBL VALUES('C14','서울캠핑','전라남도 여수시 종화동','061-785-6464','이서울','seoul@naver.com')
INSERT INTO SHOPTBL VALUES('C15','대구캠핑','전라북도 전주시 완산구 중앙동','063-484-9999','최대구','daegu@naver.com')
INSERT INTO SHOPTBL VALUES('C16','카라반캠핑','전라북도 전주시 덕진구 인후동','063-584-1356','임라반','laban@naver.com')
INSERT INTO SHOPTBL VALUES('C17','다나와캠핑','경상남도 창원시 의창구 소답동','055-886-6668','김나와','nawa@naver.com')
INSERT INTO SHOPTBL VALUES('C18','가자캠핑','경상남도 김해시 서상동','055-839-6697','김가자','gaja@naver.com')
INSERT INTO SHOPTBL VALUES('C19','스마일캠핑','경상남도 김해시 봉황동','055-870-1274','이마일','mile@naver.com')
INSERT INTO SHOPTBL VALUES('C20','스마트캠핑','충청남도 천안시 동남구 대흥동','041-878-2234','이마트','mart@naver.com')
CREATE TABLE CARTBL (CARID varCHAR(6) NOT NULL,CARNAME VARCHAR(15) NOT NULL,CARNUMBER VARCHAR(10) NOT NULL,CARPASSENGER NUMBER,CARRENTALCOST NUMBER,SHOPID varCHAR(6) NOT NULL,CARDATE TIMESTAMP(6),CARDETAIL VARCHAR(20),INUSE varCHAR(5) NOT NULL,CARIMAGE VARCHAR(20)  DEFAULT 'NO IMAGE',PRIMARY KEY(CARID),FOREIGN KEY(SHOPID) REFERENCES SHOPTBL(SHOPID) on delete cascade)
INSERT INTO CARTBL VALUES('B01','승합차형','11조1111','12','100000','C01','2017-01-01','자동/가솔린','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B02','트럭형','52조1625','3','80000','C02','2017-01-02','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B03','트럭형','64가1235','3','80000','C03','2017-01-03','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B04','트레일러형','63나2222','5','150000','C04','2017-01-04','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B05','승합차형','33호1235','12','100000','C05','2017-01-05','자동/가솔린','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B06','승합차형','36하1247','12','100000','C06','2017-01-06','자동/가솔린','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B07','승합차형','12하6573','12','100000','C07','2017-01-07','자동/가솔린','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B08','승합차형','18호1222','12','100000','C08','2017-01-08','자동/가솔린','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B09','트레일러형','35호1346','5','150000','C09','2017-01-09','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B10','트레일러형','63호1243','5','150000','C10','2017-01-10','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B11','탑차형','14하9966','3','120000','C11','2017-01-11','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B12','트럭형','35호0333','3','80000','C12','2017-01-12','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B13','트럭형','35하9955','3','80000','C13','2017-01-13','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B14','트럭형','12호0392','3','80000','C14','2017-01-14','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B15','트레일러형','14가9483','5','150000','C15','2017-01-15','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B16','트레일러형','14다1048','5','150000','C16','2017-01-16','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B17','트레일러형','86라1248','5','150000','C17','2017-01-17','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B18','트럭형','51두1295','3','80000','C18','2017-01-18','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B19','트럭형','77하7777','3','80000','C19','2017-01-03','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B20','트럭형','33호3332','3','80000','C20','2017-01-04','자동/디젤','y','NO IMAGE')
INSERT INTO CARTBL VALUES('B21','승합차형','60라4964','12','100000','C01','2017-01-05','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B22','승합차형','66자1935','12','100000','C02','2017-01-06','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B23','승합차형','11바2058','12','100000','C03','2017-01-03','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B24','승합차형','42카5075','12','100000','C04','2017-01-04','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B25','승합차형','19차1958','12','100000','C05','2017-01-05','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B26','승합차형','35타3957','12','100000','C06','2017-01-06','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B27','승합차형','25파3922','12','100000','C07','2017-01-07','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B28','승합차형','94타8674','12','100000','C08','2017-01-08','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B29','승합차형','53가9994','12','100000','C09','2017-01-09','자동/가솔린','n','NO IMAGE')
INSERT INTO CARTBL VALUES('B30','승합차형','44나3343','12','100000','C10','2017-01-06','자동/가솔린','n','NO IMAGE')
CREATE TABLE CUSTOMERTBL(CUSNAME varCHAR(10) NOT NULL,CUSADDRESS VARCHAR2(10),CUSMOBILE VARCHAR2(12),CUSEMAIL VARCHAR2(20),DRIVERNUM VARCHAR2(20) NOT NULL,PRIMARY KEY(DRIVERNUM))
INSERT INTO CUSTOMERTBL VALUES('김은주','서울','01024704745','enju@naver.com','111320022971')
INSERT INTO CUSTOMERTBL VALUES('이짱구','서울','01039673323','jjanggu@naver.com','111320022972')
INSERT INTO CUSTOMERTBL VALUES('김윤수','창원','01037671897','yunsu@naver.com','111320022973')
INSERT INTO CUSTOMERTBL VALUES('김재훈','마산','01026121376','jaehoon@naver.com','111320022974')
INSERT INTO CUSTOMERTBL VALUES('김성현','전주','01027389388','sunghyun@naver.com','111320022975')
INSERT INTO CUSTOMERTBL VALUES('이수진','전주','01091075541','sujin@naver.com','111320022976')
INSERT INTO CUSTOMERTBL VALUES('송다희','제주','01049270503','dahwi@naver.com','111320022977')
INSERT INTO CUSTOMERTBL VALUES('주세인','서울','01028051312','sein@naver.com','111320022978')
INSERT INTO CUSTOMERTBL VALUES('이소정','서울','01029206288','sojung@naver.com','111320022979')
INSERT INTO CUSTOMERTBL VALUES('정지웅','제주','01094928544','jiwoong@naver.com','111320022980')
INSERT INTO CUSTOMERTBL VALUES('박민석','용인','01051750566','minseok@naver.com','111320022981')
INSERT INTO CUSTOMERTBL VALUES('정지혜','용인','01051622533','jihye@naver.com','111320022982')
INSERT INTO CUSTOMERTBL VALUES('김예지','서울','01063235012','yeji@naver.com','111320022983')
INSERT INTO CUSTOMERTBL VALUES('이유림','용인','01058182752','yurim@naver.com','111320022984')
INSERT INTO CUSTOMERTBL VALUES('이승연','김천','01048256777','seungyun@naver.com','111320022985')
INSERT INTO CUSTOMERTBL VALUES('김지훈','김천','01088503744','jihoon@naver.com','111320022986')
INSERT INTO CUSTOMERTBL VALUES('유재진','마산','01099253833','jaejin@naver.com','111320022987')
INSERT INTO CUSTOMERTBL VALUES('이상근','김해','01028442644','sangken@naver.com','111320022988')
INSERT INTO CUSTOMERTBL VALUES('김환','여수','01040742899','hwan@naver.com','111320022989')
INSERT INTO CUSTOMERTBL VALUES('김범수','여수','01072349923','bumsu@naver.com','111320022990')
INSERT INTO CUSTOMERTBL VALUES('김덕영','서울','01055897891','dukyoung@naver.com','111320022991')
CREATE TABLE RENTALTBL(RENTNUM varCHAR(8) NOT NULL,CARID varCHAR(6) NOT NULL,DRIVERNUM VARCHAR2(20) NOT NULL,SHOPID varCHAR(6) NOT NULL,RENTDATE TIMESTAMP(6) NOT NULL,	RENTTERM NUMBER,	COST NUMBER,PAYDATE TIMESTAMP(6),ETCDETAIL VARCHAR2(20) DEFAULT 'NO DATA',ETCCOST VARCHAR2(20) DEFAULT 'NO COST',PRIMARY KEY(RENTNUM),FOREIGN KEY(CARID) REFERENCES CARTBL(CARID) on delete cascade,FOREIGN KEY(DRIVERNUM) REFERENCES CUSTOMERTBL(DRIVERNUM) on delete cascade,FOREIGN KEY(SHOPID) REFERENCES SHOPTBL(SHOPID) on delete cascade)
INSERT INTO RENTALTBL VALUES('552','B02','111320022972','C02','2013-05-14','7','560000','2013-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('553','B03','111320022973','C03','2015-05-14','7','560000','2015-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('554','B04','111320022974','C04','2018-05-14','7','1050000','2018-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('555','B05','111320022975','C05','2014-05-14','7','700000','2014-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('556','B06','111320022976','C06','2018-05-14','7','700000','2018-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('557','B07','111320022977','C07','2018-05-14','7','700000','2018-05-21','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('558','B08','111320022978','C08','2018-05-15','7','700000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('559','B09','111320022979','C09','2018-05-15','7','1050000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('560','B10','111320022980','C10','2018-05-15','7','1050000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('561','B11','111320022981','C11','2018-05-15','7','840000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('562','B12','111320022982','C12','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('563','B13','111320022983','C13','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('564','B14','111320022984','C14','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('565','B15','111320022985','C15','2018-05-15','7','1050000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('566','B16','111320022986','C16','2018-05-15','7','1050000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('567','B17','111320022987','C17','2018-05-15','7','1050000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('568','B18','111320022988','C18','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('569','B19','111320022989','C19','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('570','B20','111320022990','C20','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('571','B21','111320022991','C01','2018-05-15','7','700000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('572','B22','111320022971','C02','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('573','B23','111320022972','C03','2018-05-15','7','560000','2018-05-22','NO DATA','NO COST')
INSERT INTO RENTALTBL VALUES('577','B26','111320022975','C06','2015-10-02','7','900000','2018-05-22','NO DATA','NO COST')
CREATE TABLE REPAIRSHOPTBL(REPSHOPID VARCHAR(6) NOT NULL,REPSHOPNAME VARCHAR(20) NOT NULL,REPADDRESS VARCHAR(45),REPMOBILE VARCHAR(20),REPMANAGER VARCHAR(20),REPEMAIL VARCHAR(20),PRIMARY KEY(REPSHOPID))
INSERT INTO REPAIRSHOPTBL VALUES('A01','하나정비소','서울특별시 서대문구 홍은동','02-395-7820','김정은','hana@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A02','가나정비소','서울특별시 은평구 응암동','02-777-1352','김혜나','gana@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A03','푸른정비소','경기도 광주시 경안동','031-333-1423','김푸른','puren@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A04','다고쳐정비소','부산광역시 서구 초장동','051-523-1263','이고쳐','dagoche@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A05','동훈정비소','서울특별시 서대문구 남가좌동','02-756-3125','이동훈','donghoon@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A06','제섭정비소','서울특별시 광진구 군자동','02-999-9876','송제섭','jeseop@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A07','고친다정비소','경기도 수원시 팔달구 고등동','031-666-7765','최진다','gochinda@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A08','하늘정비소','전라남도 목포시 연당동','061-542-1533','강하늘','haneul@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A09','축제정비소','경기도 하남시 풍산동','031-755-5555','이축제','festival@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A10','세종정비소','서울특별시 광진구 화양동','02-793-3565','박세종','sejong@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A11','충암정비소','서울특별시 은평구 응암동','02-743-1555','최충암','choongam@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A12','경복정비소','서울특별시 종로구 효자동','02-376-7610','이경복','geongbok@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A13','최고정비소','강원도 춘천시 봉의동','033-1522-2223','이최고','choigo@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A14','프로정비소','전라북도 전주시 완산구 중앙동','063-3332-8683','이프로','pro@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A15','프로미정비소','경상북도 포항시 남구 송도동','054-335-3633','임로미','romi@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A16','현대정비소','강원도 원주시 중앙동','033-5353-7575','최현대','hyundai@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A17','블루정비소','서울특별시 노원구 공릉동','02-878-8554','김블루','blue@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A18','한화정비소','서울특별시 중구 무교동','02-575-2231','이한화','hanhwa@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A19','삼성정비소','서울특별시 서대문구 신촌동','02-313-8812','박삼성','samsung@naver.com')
INSERT INTO REPAIRSHOPTBL VALUES('A20','렌트정비소','서울특별시 용산구 후암동','02-377-7465','이렌트','rent@naver.com')
CREATE TABLE REPAIRTBL(REPNUM VarCHAR(6) NOT NULL,CARID varCHAR(6) NOT NULL,REPSHOPID varCHAR(6) NOT NULL,DRIVERNUM VARCHAR(20) NOT NULL,SHOPID varCHAR(6) NOT NULL,REPDETAIL VARCHAR(35) NOT NULL,REPDATE TIMESTAMP(6),REPCOST NUMBER,PAYDATE TIMESTAMP(6),ETCDETAIL VARCHAR(35) DEFAULT 'NO DATA',PRIMARY KEY(REPNUM),FOREIGN KEY(CARID) REFERENCES CARTBL(CARID) on delete cascade,FOREIGN KEY(REPSHOPID) REFERENCES REPAIRSHOPTBL(REPSHOPID) on delete cascade,FOREIGN KEY(DRIVERNUM) REFERENCES CUSTOMERTBL(DRIVERNUM) on delete cascade,FOREIGN KEY(SHOPID) REFERENCES SHOPTBL(SHOPID) on delete cascade)
INSERT INTO REPAIRTBL VALUES('111','B01','A01','111320022975','C01','와이퍼수리','2016-08-08','40000','2016-08-11','NO DATA')
INSERT INTO REPAIRTBL VALUES('112','B02','A02','111320022976','C02','전면부도색','2018-01-12','100000','2018-01-15','NO DATA')
INSERT INTO REPAIRTBL VALUES('113','B03','A03','111320022977','C03','와이퍼수리','2017-12-12','40000','2017-12-15','NO DATA')
INSERT INTO REPAIRTBL VALUES('114','B04','A04','111320022978','C04','후면부도색','2017-12-31','120000','2016-01-03','NO DATA')
INSERT INTO REPAIRTBL VALUES('115','B05','A05','111320022979','C05','후면부도색','2005-12-22','120000','2005-12-25','NO DATA')
INSERT INTO REPAIRTBL VALUES('116','B06','A06','111320022980','C06','좌측면외형복원','2015-12-11','200000','2015-12-14','NO DATA')
INSERT INTO REPAIRTBL VALUES('117','B07','A07','111320022981','C07','우측면외형복원','2018-01-29','200000','2018-02-01','NO DATA')
INSERT INTO REPAIRTBL VALUES('118','B08','A08','111320022982','C08','와이퍼수리','2018-01-20','40000','2018-01-23','NO DATA')
INSERT INTO REPAIRTBL VALUES('119','B09','A09','111320022983','C09','전면부도색','2018-03-18','100000','2018-03-21','NO DATA')
INSERT INTO REPAIRTBL VALUES('120','B10','A10','111320022984','C10','트렁크외형복원','2018-04-28','150000','2018-05-01','NO DATA')
INSERT INTO REPAIRTBL VALUES('121','B11','A11','111320022985','C11','범퍼수리','2017-10-01','50000','2017-10-04','NO DATA')
INSERT INTO REPAIRTBL VALUES('122','B12','A12','111320022986','C12','범퍼수리','2017-05-22','50000','2017-05-25','NO DATA')