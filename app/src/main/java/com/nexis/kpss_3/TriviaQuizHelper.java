
package com.nexis.kpss_3;

import static com.nexis.kpss_3.TriviaQuizContract.QuestionTable.TABLE_NAME;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.nexis.kpss_3.TriviaQuizContract.*;

import java.util.ArrayList;

public class TriviaQuizHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATABASE_VERSION = 12; // Versiyon güncellendi
    private SQLiteDatabase db;

    public TriviaQuizHelper(Context context) {
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " (" +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void addQuestions(TriviaQuestion question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_OPTION5,question.getOption5());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswer_nr());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
// Türkçe Soruları
        TriviaQuestion q1 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde özne eksikliğinden kaynaklanan bir anlatım bozukluğu vardır?",
                "A) Sabah erkenden kalkıp kahvaltı yaptık.",
                "B) Kitapları raftan alıp masaya koydu.",
                "C) Çocuklar parkta oynarken anneleri sohbet etti.",
                "D) Dersi dinleyip notlar aldım.",
                "E) Sınava çalıştı, ama soruları anlamadı.",
                "B) Kitapları raftan alıp masaya koydu.",
                "Türkçe"
        );

        TriviaQuestion q2 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde bir yazım yanlışı vardır?",
                "A) Bu hafta sonu sinemaya gideceğiz.",
                "B) Yarın sabah saat 07.00’de kalkacağım.",
                "C) Ders çalışmayı çok seviyorum.",
                "D) Bu kitabı çok beyenerek okudum.",
                "E) Hafta içi genellikle erken uyanırım.",
                "D) Bu kitabı çok beyenerek okudum.",
                "Türkçe"
        );

        TriviaQuestion q3 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'de' bağlacı yanlış yazılmıştır?",
                "A) Bahçede çok güzel çiçekler var.",
                "B) Kitabı masanın üstüne koydu ve gitti.",
                "C) Okuldan sonra sinemaya da gidebiliriz.",
                "D) Seni gördüğümde çok mutlu oldum.",
                "E) Kitap okumayı seviyorum de arkadaşlarım pek ilgilenmiyor.",
                "E) Kitap okumayı seviyorum de arkadaşlarım pek ilgilenmiyor.",
                "Türkçe"
        );
        TriviaQuestion q4 = new TriviaQuestion(
                "Aşağıdaki cümlede hangi sözcük gereksiz kullanılmıştır?",
                "A) Çocuklar dışarıda oyun oynuyor.",
                "B) O kadar hızlı koştu ki yetişemedim.",
                "C) Kitapları yerleştirirken dikkatli ol.",
                "D) Beni neden çağırmadınız, merak ettim.",
                "E) Okuldan sonra sinemaya gideceğiz.",
                "D) Beni neden çağırmadınız, merak ettim.",
                "Türkçe"
        );
        TriviaQuestion q5 = new TriviaQuestion(
                "Aşağıdaki cümlede hangi sözcük yanlış kullanılmıştır?",
                "A) Akşam yemeğinde pizza yiyeceğiz.",
                "B) Dışarıda yağmur yağıyor.",
                "C) Kütüphane çok kalabalıktı.",
                "D) Çocuklar parkta eğlendiler.",
                "E) Film çok uzun sürecek.",
                "C) Kütüphane çok kalabalıktı.",
                "Türkçe"
        );
// Matematik Soruları
        TriviaQuestion q6 = new TriviaQuestion(
                "Bir çarpma işleminin sonucu 72, bölenlerden biri 9 ise diğerini bulunuz.",
                "A) 8",
                "B) 10",
                "C) 12",
                "D) 6",
                "E) 4",
                "A) 8",
                "Matematik"
        );
        TriviaQuestion q7 = new TriviaQuestion(
                "Bir dikdörtgenin kısa kenarı 5 cm, uzun kenarı ise 8 cm. Dikdörtgenin çevresini bulunuz.",
                "A) 13 cm",
                "B) 26 cm",
                "C) 40 cm",
                "D) 30 cm",
                "E) 48 cm",
                "B) 26 cm",
                "Matematik"
        );
        TriviaQuestion q8 = new TriviaQuestion(
                "Bir üçgenin iki kenarının uzunluğu 5 cm ve 12 cm. Diğer kenar 13 cm. Bu üçgenin türü nedir?",
                "A) Dik Üçgen",
                "B) Eşkenar Üçgen",
                "C) İkizkenar Üçgen",
                "D) Geniş Açılı Üçgen",
                "E) Dar Açılı Üçgen",
                "A) Dik Üçgen",
                "Matematik"
        );
        TriviaQuestion q9 = new TriviaQuestion(
                "Bir dairenin çapı 10 cm. Dairenin alanını hesaplayınız. (π = 3,14)",
                "A) 314 cm²",
                "B) 78,5 cm²",
                "C) 100 cm²",
                "D) 50 cm²",
                "E) 25 cm²",
                "B) 78,5 cm²",
                "Matematik"
        );
        TriviaQuestion q10 = new TriviaQuestion(
                "Bir sayının 3 katının 5 fazlası 26'dır. Bu sayıyı bulunuz.",
                "A) 6",
                "B) 7",
                "C) 8",
                "D) 5",
                "E) 9",
                "A) 6",
                "Matematik"
        );
        TriviaQuestion q11 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'de' bağlacı yanlış kullanılmıştır?",
                "A) O da bizimle gelecek.",
                "B) Kitapları da almayı unutma.",
                "C) Sen de mi Brütüs?",
                "D) Bu soruyu da çözemedim.",
                "E) Dün gece de yağmur yağdı.",
                "C) Sen de mi Brütüs?",
                "Türkçe"
        );

        TriviaQuestion q12 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'ki' bağlacı doğru kullanılmıştır?",
                "A) Anladımki sen de gelmeyeceksin.",
                "B) Biliyorsunki o da haklı.",
                "C) Duydumki yeni bir iş bulmuşsun.",
                "D) Sanırımki o da gelecektir.",
                "E) Düşündüm ki doğruyu söylüyorsun.",
                "E) Düşündüm ki doğruyu söylüyorsun.",
                "Türkçe"
        );

        TriviaQuestion q13 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'mi' soru eki bitişik yazılmıştır?",
                "A) Geliyormusun?",
                "B) Biliyor musun?",
                "C) Anladın mı?",
                "D) Gidiyor musunuz?",
                "E) Geldin mi?",
                "A) Geliyormusun?",
                "Türkçe"
        );

        TriviaQuestion q14 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde yazım yanlışı vardır?",
                "A) Bugün hava çok güzel.",
                "B) Yarın ki toplantıya katılacağım.",
                "C) Kitapları masaya koy.",
                "D) Onunla konuşmalısın.",
                "E) Bu soruyu çözemedim.",
                "B) Yarın ki toplantıya katılacağım.",
                "Türkçe"
        );

        TriviaQuestion q15 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde noktalama işareti yanlış kullanılmıştır?",
                "A) Ali, Ayşe ve Mehmet geldi.",
                "B) Bugün hava çok güzel; fakat yarın yağmur bekleniyor.",
                "C) O, çok çalışkan bir öğrenci.",
                "D) Ahmet, eve geldi mi?",
                "E) Bu, benim kitabım mı?",
                "D) Ahmet, eve geldi mi?",
                "Türkçe"
        );

        TriviaQuestion q16 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde anlatım bozukluğu vardır?",
                "A) O, çok çalışkan ve başarılı bir öğrencidir.",
                "B) Kitapları masaya koy ve defterleri de al.",
                "C) Hem çalışıyor hem de okuyor.",
                "D) Bu soruyu çözmek için çok çalışmalısın.",
                "E) Onunla birlikte sinemaya gittik ve film izledik.",
                "E) Onunla birlikte sinemaya gittik ve film izledik.",
                "Türkçe"
        );

        TriviaQuestion q17 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'ile' edatı bitişik yazılmıştır?",
                "A) Aliyle okula gittik.",
                "B) Ayşe ile sinemaya gideceğiz.",
                "C) Mehmet'le konuşmalısın.",
                "D) Kitap ile defteri al.",
                "E) Onunla birlikte geldik.",
                "A) Aliyle okula gittik.",
                "Türkçe"
        );

        TriviaQuestion q18 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'mi' soru eki yanlış yazılmıştır?",
                "A) Geliyor musun?",
                "B) Biliyor musun?",
                "C) Anladın mı?",
                "D) Gidiyor musunuz?",
                "E) Geldinmi?",
                "E) Geldinmi?",
                "Türkçe"
        );

        TriviaQuestion q19 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde büyük harflerin kullanımıyla ilgili bir hata vardır?",
                "A) Ankara Türkiye'nin başkentidir.",
                "B) İstanbul Boğazı çok güzeldir.",
                "C) Atatürk, Türkiye Cumhuriyeti'nin kurucusudur.",
                "D) Ahmet Bey bugün gelmedi.",
                "E) Yazın Antalya'ya tatile gideceğiz.",
                "E) Yazın Antalya'ya tatile gideceğiz.",
                "Türkçe"
        );

        TriviaQuestion q20 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'de' bağlacı yanlış yazılmıştır?",
                "A) O da bizimle gelecek.",
                "B) Kitapları da almayı unutma.",
                "C) Sen de mi Brütüs?",
                "D) Bu soruyu da çözemedim.",
                "E) Dün gece de yağmur yağdı.",
                "C) Sen de mi Brütüs?",
                "Türkçe"
        );

        TriviaQuestion q21 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'ki' bağlacı doğru yazılmıştır?",
                "A) Anladımki sen de gelmeyeceksin.",
                "B) Biliyorsunki o da haklı.",
                "C) Duydumki yeni bir iş bulmuşsun.",
                "D) Sanırımki o da gelecektir.",
                "E) Düşündüm ki doğruyu söylüyorsun.",
                "E) Düşündüm ki doğruyu söylüyorsun.",
                "Türkçe"
        );

        TriviaQuestion q22 = new TriviaQuestion(
                "Aşağıdaki cümlelerin hangisinde 'mi' soru eki bitişik yazılmıştır?",
                "A) Geliyormusun?",
                "B) Biliyor musun?",
                "C) Anladın mı?",
                "D) Gidiyor musunuz?",
                "E) Geldin mi?",
                "A) Geliyormusun?",
                "Türkçe"
        );
        TriviaQuestion q23 = new TriviaQuestion(
                "Sanayi faaliyetleri, şehirleşmenin artışı ve insanların doğaya müdahalesi, çevre sorunlarını her geçen gün daha da derinleştirmektedir. Özellikle hava kirliliği, su kaynaklarının kirlenmesi ve ormanların yok edilmesi gibi konular, dünya genelinde ciddi etkiler yaratmaktadır. Bu paragrafın konusu nedir?",
                "A) Kitap okumanın faydaları",
                "B) Çevre kirliliğinin etkileri",
                "C) Sporun önemi",
                "D) Tarih bilincinin gerekliliği",
                "E) İnsan hakları ve özgürlükler",
                "B) Çevre kirliliğinin etkileri",
                "Türkçe"
        );

        TriviaQuestion q24 = new TriviaQuestion(
                "Sabah güneşinin altın sarısı ışıkları pencere camından içeri süzülüyordu. Bahçedeki güller yeni açmış, kuşlar neşeyle cıvıldıyordu. Hafif esen rüzgâr, ağaç yapraklarını nazikçe sallarken çocuklar bahçede oynamaya başlamıştı. Bu paragrafın anlatım biçimi nedir?",
                "A) Açıklama",
                "B) Tartışma",
                "C) Betimleme",
                "D) Öyküleme",
                "E) Kanıtlama",
                "C) Betimleme",
                "Türkçe"
        );

        TriviaQuestion q25 = new TriviaQuestion(
                "İnsan, yaşadığı olaylardan ders çıkarabildiği sürece gelişebilir. Düşünmek, sadece sorunları çözmek için değil, aynı zamanda geleceği şekillendirmek için de bir ihtiyaçtır. Ancak düşünmeden hareket eden bir birey, hatalarını sürekli tekrarlar. Parçada vurgulanmak istenen düşünce nedir?",
                "A) Bilginin gücü büyüktür.",
                "B) Düşünmek insana yön verir.",
                "C) Sanat insanı geliştirir.",
                "D) Doğa korunmalıdır.",
                "E) Eğitim hayatı şekillendirir.",
                "B) Düşünmek insana yön verir.",
                "Türkçe"
        );

        TriviaQuestion q26 = new TriviaQuestion(
                "Toplumdaki adaletsizlikleri görmezden gelmek, sorunların çözümünü daha da geciktirir. İnsanlar, başkalarının acılarını duymazdan geldiğinde, bir gün o acı kendi kapısını çaldığında şaşırmamalıdır. Bu paragrafın tonu nasıldır?",
                "A) Neşeli",
                "B) Kederli",
                "C) Resmi",
                "D) Samimi",
                "E) Eleştirel",
                "E) Eleştirel",
                "Türkçe"
        );

        TriviaQuestion q27 = new TriviaQuestion(
                "Bir yazar, kişisel düşüncelerini ve duygularını içtenlikle kaleme almış, okuyucusuna açık bir anlatımla seslenmiştir. Bilimsel verilerden çok kendi yaşantısından ve izlenimlerinden bahsetmiştir. Bu paragraf hangi tür yazıdan alınmıştır?",
                "A) Makale",
                "B) Deneme",
                "C) Hikaye",
                "D) Röportaj",
                "E) Günlük",
                "B) Deneme",
                "Türkçe"
        );

        TriviaQuestion q28 = new TriviaQuestion(
                "İnsanların birbirini anlaması, toplumsal yaşamın en temel unsurlarından biridir. Karşısındakini dinlemeyi bilen, onun duygularını anlayabilen bir birey, sağlıklı iletişim kurar ve topluma katkı sağlar. Parçada hangi düşünce savunulmaktadır?",
                "A) Teknoloji insan hayatını olumlu etkiler.",
                "B) Sanat kişisel gelişimi destekler.",
                "C) Çalışkan olmak başarı getirir.",
                "D) Empati sosyal ilişkileri güçlendirir.",
                "E) Tarih bilinci geleceği şekillendirir.",
                "D) Empati sosyal ilişkileri güçlendirir.",
                "Türkçe"
        );

        TriviaQuestion q29 = new TriviaQuestion(
                "Okuma alışkanlığı kazanan birey, hem kelime dağarcığını geliştirir hem de farklı bakış açıları kazanır. Kitaplar, sadece bilgi kaynağı değil, aynı zamanda insanın duygusal ve düşünsel gelişimini destekleyen dostlardır. Parçada verilen düşünceye göre en uygun başlık aşağıdakilerden hangisidir?",
                "A) Bilim ve Teknoloji",
                "B) Kitap Okumanın Önemi",
                "C) Tarihin İzleri",
                "D) Çevre Bilinci",
                "E) Sanatın Gücü",
                "B) Kitap Okumanın Önemi",
                "Türkçe"
        );

        TriviaQuestion q30 = new TriviaQuestion(
                "Bazı insanlar, hayatın karmaşasını anlatırken, çocukluğunu ve ailesinden öğrendiklerini örnek verir. Bu örnekler, düşüncelerini desteklemek ve okuyucunun konuyla bağ kurmasını sağlamak için kullanılır. Bu paragrafta hangi anlatım tekniği kullanılmıştır?",
                "A) Karşılaştırma",
                "B) Tanımlama",
                "C) Örneklendirme",
                "D) Benzetme",
                "E) Kanıtlama",
                "C) Örneklendirme",
                "Türkçe"
        );

        TriviaQuestion q31 = new TriviaQuestion(
                "Bir dikdörtgenin kısa kenarı 6 cm, uzun kenarı ise 10 cm'dir. Dikdörtgenin alanı kaç cm²'dir?",
                "A) 16",
                "B) 36",
                "C) 60",
                "D) 80",
                "E) 100",
                "C) 60",
                "Matematik"
        );

        TriviaQuestion q32 = new TriviaQuestion(
                "Bir çemberin çapı 14 cm ise çevresi kaç cm'dir? (π = 3,14 alınacaktır.)",
                "A) 21,98",
                "B) 43,96",
                "C) 48,12",
                "D) 51,24",
                "E) 56,78",
                "B) 43,96",
                "Matematik"
        );

        TriviaQuestion q33 = new TriviaQuestion(
                "Bir mağaza, satış fiyatı 400 TL olan bir ürünü %25 indirimle satmaktadır. İndirimli fiyat kaç TL'dir?",
                "A) 250",
                "B) 275",
                "C) 300",
                "D) 325",
                "E) 350",
                "C) 300",
                "Matematik"
        );

        TriviaQuestion q34 = new TriviaQuestion(
                "Bir çiftlikte 5 tavuk günde toplam 30 yumurta yapıyorsa, 8 tavuk aynı sürede kaç yumurta yapar?",
                "A) 42",
                "B) 45",
                "C) 48",
                "D) 50",
                "E) 54",
                "C) 48",
                "Matematik"
        );

        TriviaQuestion q35 = new TriviaQuestion(
                "Bir otomobil saatte 90 km hızla hareket ediyor. 4 saatte kaç km yol alır?",
                "A) 200",
                "B) 250",
                "C) 300",
                "D) 360",
                "E) 400",
                "D) 360",
                "Matematik"
        );

        TriviaQuestion q36 = new TriviaQuestion(
                "Bir su deposu 15 saatte tamamen dolmaktadır. Depo 5 saat çalıştırıldıktan sonra içindeki suyun 3/5’i kullanıldığında, depoda kaç saatlik su kalmıştır?",
                "A) 2",
                "B) 3",
                "C) 4",
                "D) 5",
                "E) 6",
                "C) 4",
                "Matematik"
        );

        TriviaQuestion q37 = new TriviaQuestion(
                "Bir küpün bir ayrıtı 4 cm’dir. Küpün hacmi kaç cm³’tür?",
                "A) 16",
                "B) 32",
                "C) 48",
                "D) 64",
                "E) 80",
                "D) 64",
                "Matematik"
        );

        TriviaQuestion q38 = new TriviaQuestion(
                "Bir dik üçgenin dik kenarları 6 cm ve 8 cm’dir. Hipotenüs uzunluğu kaç cm’dir?",
                "A) 8",
                "B) 10",
                "C) 12",
                "D) 14",
                "E) 16",
                "B) 10",
                "Matematik"
        );

        TriviaQuestion q39 = new TriviaQuestion(
                "Bir sınıfta 18 erkek ve 12 kız öğrenci bulunmaktadır. Sınıftaki kız öğrencilerin oranı nedir?",
                "A) 20%",
                "B) 30%",
                "C) 40%",
                "D) 50%",
                "E) 60%",
                "C) 40%",
                "Matematik"
        );

        TriviaQuestion q40 = new TriviaQuestion(
                "Bir karışımın %40’ı su, geri kalanı şekerdir. Eğer karışımın toplam ağırlığı 150 gram ise, karışımdaki şeker miktarı kaç gramdır?",
                "A) 40",
                "B) 50",
                "C) 60",
                "D) 70",
                "E) 90",
                "C) 60",
                "Matematik"
        );
        TriviaQuestion q41 = new TriviaQuestion(
                "Bir dikdörtgenin çevresi 48 cm’dir. Kısa kenarı 10 cm ise uzun kenarı kaç cm’dir?",
                "A) 12",
                "B) 14",
                "C) 16",
                "D) 18",
                "E) 20",
                "C) 14",
                "Matematik"
        );

        TriviaQuestion q42 = new TriviaQuestion(
                "Bir karenin alanı 64 cm² ise, çevresi kaç cm’dir?",
                "A) 16",
                "B) 24",
                "C) 32",
                "D) 40",
                "E) 48",
                "C) 32",
                "Matematik"
        );

        TriviaQuestion q43 = new TriviaQuestion(
                "Bir market, 600 TL’ye sattığı bir ürünü %15 indirimle satmaktadır. Ürünün yeni fiyatı kaç TL’dir?",
                "A) 450",
                "B) 480",
                "C) 510",
                "D) 520",
                "E) 540",
                "C) 510",
                "Matematik"
        );

        TriviaQuestion q44 = new TriviaQuestion(
                "Bir otobüs, 3 saatte 240 km yol almıştır. Otobüsün ortalama hızı kaç km/saattir?",
                "A) 60",
                "B) 70",
                "C) 75",
                "D) 80",
                "E) 85",
                "D) 80",
                "Matematik"
        );

        TriviaQuestion q45 = new TriviaQuestion(
                "Bir grup işçi, bir işi 12 günde bitirebiliyorsa, aynı işi 4 işçi daha fazla çalışarak kaç günde bitirebilir?",
                "A) 6",
                "B) 8",
                "C) 9",
                "D) 10",
                "E) 12",
                "B) 8",
                "Matematik"
        );

        TriviaQuestion q46 = new TriviaQuestion(
                "Bir baba ve oğlu toplam 50 yaşındadır. Babanın yaşı, oğlunun yaşının 4 katıdır. Oğul kaç yaşındadır?",
                "A) 8",
                "B) 10",
                "C) 12",
                "D) 14",
                "E) 16",
                "B) 10",
                "Matematik"
        );

        TriviaQuestion q47 = new TriviaQuestion(
                "Bir musluk bir havuzu tek başına 6 saatte dolduruyor. İkinci bir musluk açıldığında havuz 4 saatte doluyor. İkinci musluk tek başına kaç saatte doldurur?",
                "A) 8",
                "B) 10",
                "C) 12",
                "D) 14",
                "E) 16",
                "C) 12",
                "Matematik"
        );

        TriviaQuestion q48 = new TriviaQuestion(
                "Bir havuz, bir muslukla 15 saatte boşalıyor. Havuzun 3/5’i boşaltıldıysa, geriye kaç saatlik su kalmıştır?",
                "A) 3",
                "B) 4",
                "C) 5",
                "D) 6",
                "E) 7",
                "C) 6",
                "Matematik"
        );

        TriviaQuestion q49 = new TriviaQuestion(
                "Bir kişinin maaşı %20 artırılarak 6000 TL’ye çıkarıldı. Kişinin önceki maaşı kaç TL idi?",
                "A) 4500",
                "B) 4800",
                "C) 5000",
                "D) 5200",
                "E) 5500",
                "C) 5000",
                "Matematik"
        );

        TriviaQuestion q50 = new TriviaQuestion(
                "Bir okulda 300 öğrenci bulunmaktadır. Öğrencilerin %40’ı kız ise, erkek öğrenci sayısı kaçtır?",
                "A) 120",
                "B) 150",
                "C) 180",
                "D) 200",
                "E) 220",
                "C) 180",
                "Matematik"
        );
        TriviaQuestion q51 = new TriviaQuestion(
                "Malazgirt Meydan Muharebesi hangi yıl gerçekleşmiştir?",
                "A) 1055",
                "B) 1071",
                "C) 1096",
                "D) 1147",
                "E) 1176",
                "B) 1071",
                "Tarih"
        );

        TriviaQuestion q52 = new TriviaQuestion(
                "İstanbul'un fethi hangi padişah döneminde gerçekleşmiştir?",
                "A) Yıldırım Bayezid",
                "B) II. Murad",
                "C) II. Mehmet",
                "D) I. Selim",
                "E) III. Murad",
                "C) II. Mehmet",
                "Tarih"
        );

        TriviaQuestion q53 = new TriviaQuestion(
                "Türkiye Cumhuriyeti'nin ilk Cumhurbaşkanı kimdir?",
                "A) İsmet İnönü",
                "B) Celal Bayar",
                "C) Mustafa Kemal Atatürk",
                "D) Adnan Menderes",
                "E) Turgut Özal",
                "C) Mustafa Kemal Atatürk",
                "Tarih"
        );

        TriviaQuestion q54 = new TriviaQuestion(
                "Kurtuluş Savaşı'nda kazanılan ilk büyük zafer aşağıdakilerden hangisidir?",
                "A) Sakarya Meydan Muharebesi",
                "B) Büyük Taarruz",
                "C) I. İnönü Muharebesi",
                "D) II. İnönü Muharebesi",
                "E) Kütahya-Eskişehir Muharebeleri",
                "C) I. İnönü Muharebesi",
                "Tarih"
        );

        TriviaQuestion q55 = new TriviaQuestion(
                "Lozan Antlaşması hangi yıl imzalanmıştır?",
                "A) 1919",
                "B) 1921",
                "C) 1923",
                "D) 1925",
                "E) 1930",
                "C) 1923",
                "Tarih"
        );

        TriviaQuestion q56 = new TriviaQuestion(
                "Osmanlı Devleti'nin ilk başkenti aşağıdakilerden hangisidir?",
                "A) Bursa",
                "B) Edirne",
                "C) İstanbul",
                "D) Ankara",
                "E) Konya",
                "A) Bursa",
                "Tarih"
        );

        TriviaQuestion q57 = new TriviaQuestion(
                "Selçuklu Devleti'nin kurucusu kimdir?",
                "A) Tuğrul Bey",
                "B) Alparslan",
                "C) Melikşah",
                "D) Sultan Sencer",
                "E) Süleyman Şah",
                "A) Tuğrul Bey",
                "Tarih"
        );

        TriviaQuestion q58 = new TriviaQuestion(
                "Atatürk'ün Nutuk adlı eseri hangi yıl yayımlanmıştır?",
                "A) 1919",
                "B) 1925",
                "C) 1927",
                "D) 1931",
                "E) 1935",
                "C) 1927",
                "Tarih"
        );

        TriviaQuestion q59 = new TriviaQuestion(
                "İlk TBMM hangi tarihte açılmıştır?",
                "A) 23 Nisan 1920",
                "B) 29 Ekim 1923",
                "C) 4 Eylül 1919",
                "D) 19 Mayıs 1919",
                "E) 1 Kasım 1922",
                "A) 23 Nisan 1920",
                "Tarih"
        );

        TriviaQuestion q60 = new TriviaQuestion(
                "Osmanlı Devleti'nin en uzun süre tahtta kalan padişahı kimdir?",
                "A) Kanuni Sultan Süleyman",
                "B) Yavuz Sultan Selim",
                "C) III. Selim",
                "D) II. Abdülhamid",
                "E) I. Ahmed",
                "A) Kanuni Sultan Süleyman",
                "Tarih"
        );

        TriviaQuestion q61 = new TriviaQuestion(
                "Mondros Ateşkes Antlaşması hangi savaşın sonunda imzalanmıştır?",
                "A) I. Dünya Savaşı",
                "B) II. Dünya Savaşı",
                "C) Kurtuluş Savaşı",
                "D) Balkan Savaşları",
                "E) Kırım Savaşı",
                "A) I. Dünya Savaşı",
                "Tarih"
        );

        TriviaQuestion q62 = new TriviaQuestion(
                "Türkiye'nin ilk Başbakanı kimdir?",
                "A) Celal Bayar",
                "B) İsmet İnönü",
                "C) Adnan Menderes",
                "D) Turgut Özal",
                "E) Bülent Ecevit",
                "B) İsmet İnönü",
                "Tarih"
        );

        TriviaQuestion q63 = new TriviaQuestion(
                "Osmanlı Devleti hangi antlaşma ile fiilen sona ermiştir?",
                "A) Sevr Antlaşması",
                "B) Mondros Ateşkes Antlaşması",
                "C) Lozan Antlaşması",
                "D) Ankara Antlaşması",
                "E) Kars Antlaşması",
                "A) Sevr Antlaşması",
                "Tarih"
        );

        TriviaQuestion q64 = new TriviaQuestion(
                "İkinci Meşrutiyet hangi yıl ilan edilmiştir?",
                "A) 1876",
                "B) 1908",
                "C) 1913",
                "D) 1920",
                "E) 1930",
                "B) 1908",
                "Tarih"
        );
        TriviaQuestion q65 = new TriviaQuestion(
                "Türkiye Cumhuriyeti Anayasası'nın yürürlüğe girdiği yıl hangisidir?",
                "A) 1920",
                "B) 1924",
                "C) 1961",
                "D) 1982",
                "E) 2017",
                "D) 1982",
                "Anayasa"
        );

        TriviaQuestion q66 = new TriviaQuestion(
                "Anayasa Mahkemesi kaç üyeden oluşur?",
                "A) 11",
                "B) 15",
                "C) 17",
                "D) 21",
                "E) 25",
                "B) 15",
                "Anayasa"
        );

        TriviaQuestion q67 = new TriviaQuestion(
                "Türkiye Cumhuriyeti'nde halk oylaması ile kabul edilen ilk anayasa değişikliği hangi yılda yapılmıştır?",
                "A) 1961",
                "B) 1971",
                "C) 1982",
                "D) 2007",
                "E) 2010",
                "D) 2007",
                "Anayasa"
        );

        TriviaQuestion q68 = new TriviaQuestion(
                "Türkiye Cumhuriyeti'nde yürütme yetkisi ve görevi kim tarafından yerine getirilir?",
                "A) Cumhurbaşkanı",
                "B) Başbakan",
                "C) Bakanlar Kurulu",
                "D) TBMM",
                "E) Yargıtay",
                "A) Cumhurbaşkanı",
                "Anayasa"
        );

        TriviaQuestion q69 = new TriviaQuestion(
                "Türkiye'de ilk Anayasa hangi yıl kabul edilmiştir?",
                "A) 1876",
                "B) 1908",
                "C) 1921",
                "D) 1924",
                "E) 1982",
                "A) 1876",
                "Anayasa"
        );

        TriviaQuestion q70 = new TriviaQuestion(
                "Anayasa'nın değiştirilmesi için TBMM'de en az kaç milletvekilinin teklifi gerekir?",
                "A) 100",
                "B) 184",
                "C) 200",
                "D) 275",
                "E) 330",
                "E) 330",
                "Anayasa"
        );

        TriviaQuestion q71 = new TriviaQuestion(
                "Türkiye Cumhuriyeti'nin yönetim biçimi Anayasa'nın kaçıncı maddesinde belirtilmiştir?",
                "A) 1. madde",
                "B) 2. madde",
                "C) 3. madde",
                "D) 4. madde",
                "E) 5. madde",
                "A) 1. madde",
                "Anayasa"
        );

        TriviaQuestion q72 = new TriviaQuestion(
                "Anayasa'ya göre temel hak ve hürriyetler hangi durumlarda kısıtlanabilir?",
                "A) Hiçbir zaman kısıtlanamaz.",
                "B) Olağanüstü hallerde ve savaş durumlarında.",
                "C) TBMM kararıyla herhangi bir zamanda.",
                "D) Cumhurbaşkanı kararıyla.",
                "E) İçişleri Bakanlığı yetkisiyle.",
                "B) Olağanüstü hallerde ve savaş durumlarında.",
                "Anayasa"
        );

        TriviaQuestion q73 = new TriviaQuestion(
                "Anayasa'ya göre egemenlik kime aittir?",
                "A) Devlet Başkanı'na",
                "B) TBMM'ye",
                "C) Türk Milleti'ne",
                "D) Bakanlar Kurulu'na",
                "E) Anayasa Mahkemesi'ne",
                "C) Türk Milleti'ne",
                "Anayasa"
        );

        TriviaQuestion q74 = new TriviaQuestion(
                "Anayasa Mahkemesi üyeleri kaç yıl için seçilir?",
                "A) 4 yıl",
                "B) 6 yıl",
                "C) 10 yıl",
                "D) 12 yıl",
                "E) Ömür boyu",
                "D) 12 yıl",
                "Anayasa"
        );

        TriviaQuestion q75 = new TriviaQuestion(
                "Türkiye Cumhuriyeti Anayasası'na göre, temel haklar ve özgürlükler hangi şartlarla sınırlanabilir?",
                "A) Cumhurbaşkanı kararıyla",
                "B) Bakanlar Kurulu kararıyla",
                "C) Savaş, seferberlik, olağanüstü hal durumlarında",
                "D) TBMM kararıyla her durumda",
                "E) Yargıtay'ın onayı ile",
                "C) Savaş, seferberlik, olağanüstü hal durumlarında",
                "Anayasa"
        );

        TriviaQuestion q76 = new TriviaQuestion(
                "Türkiye Büyük Millet Meclisi’nin seçimleri kaç yılda bir yapılır?",
                "A) 4 yıl",
                "B) 5 yıl",
                "C) 6 yıl",
                "D) 7 yıl",
                "E) 10 yıl",
                "B) 5 yıl",
                "Anayasa"
        );

        TriviaQuestion q77 = new TriviaQuestion(
                "Anayasa değişikliklerinde halk oylaması kaç gün içinde yapılmalıdır?",
                "A) 30 gün",
                "B) 45 gün",
                "C) 60 gün",
                "D) 75 gün",
                "E) 90 gün",
                "C) 60 gün",
                "Anayasa"
        );

        TriviaQuestion q78 = new TriviaQuestion(
                "Türkiye’de Cumhurbaşkanı kaç yıl süreyle seçilir?",
                "A) 4 yıl",
                "B) 5 yıl",
                "C) 6 yıl",
                "D) 7 yıl",
                "E) 10 yıl",
                "B) 5 yıl",
                "Anayasa"
        );

        TriviaQuestion q79 = new TriviaQuestion(
                "Yasama yetkisi kime aittir?",
                "A) Cumhurbaşkanı",
                "B) TBMM",
                "C) Anayasa Mahkemesi",
                "D) Danıştay",
                "E) Bakanlar Kurulu",
                "B) TBMM",
                "Anayasa"
        );

        TriviaQuestion q80 = new TriviaQuestion(
                "Türkiye Cumhuriyeti Anayasası'na göre Cumhurbaşkanı aday gösterme şartlarından biri değildir?",
                "A) 40 yaşını doldurmuş olmak",
                "B) Türkiye Cumhuriyeti vatandaşı olmak",
                "C) Yükseköğrenim yapmış olmak",
                "D) En az 20 milletvekili tarafından önerilmek",
                "E) 5 yıldır kamuda görev yapıyor olmak",
                "E) 5 yıldır kamuda görev yapıyor olmak",
                "Anayasa"
        );
        TriviaQuestion q81 = new TriviaQuestion(
                "2024 yılında düzenlenen Yaz Olimpiyatları hangi şehirde yapılacaktır?",
                "A) Tokyo",
                "B) Paris",
                "C) Los Angeles",
                "D) Londra",
                "E) Pekin",
                "B) Paris",
                "Güncel"
        );

        TriviaQuestion q82 = new TriviaQuestion(
                "2023 yılında Türkiye'de yürürlüğe giren EYT (Emeklilikte Yaşa Takılanlar) düzenlemesi ile ilgili doğru ifade hangisidir?",
                "A) 55 yaş ve üzeri herkes emekli olabilir.",
                "B) Sigortalılık süresi ve prim gün sayısını dolduranlar yaş şartı olmadan emekli olabilir.",
                "C) Sadece kamu çalışanlarını kapsayan bir düzenlemedir.",
                "D) Emeklilik yaşı 65'e çekilmiştir.",
                "E) Özel sektör çalışanlarını kapsamamaktadır.",
                "B) Sigortalılık süresi ve prim gün sayısını dolduranlar yaş şartı olmadan emekli olabilir.",
                "Güncel"
        );

        TriviaQuestion q83 = new TriviaQuestion(
                "2023 yılında Nobel Barış Ödülü'nü kazanan kişi kimdir?",
                "A) Malala Yousafzai",
                "B) Maria Ressa",
                "C) Narges Mohammadi",
                "D) Abiy Ahmed",
                "E) Greta Thunberg",
                "C) Narges Mohammadi",
                "Güncel"
        );

        TriviaQuestion q84 = new TriviaQuestion(
                "2023 Türkiye genel seçimlerinde Cumhurbaşkanı olarak seçilen kişi kimdir?",
                "A) Kemal Kılıçdaroğlu",
                "B) Recep Tayyip Erdoğan",
                "C) Meral Akşener",
                "D) Ekrem İmamoğlu",
                "E) Devlet Bahçeli",
                "B) Recep Tayyip Erdoğan",
                "Güncel"
        );

        TriviaQuestion q85 = new TriviaQuestion(
                "2024 Avrupa Futbol Şampiyonası (EURO 2024) hangi ülkede düzenlenecektir?",
                "A) İspanya",
                "B) Fransa",
                "C) Almanya",
                "D) İtalya",
                "E) İngiltere",
                "C) Almanya",
                "Güncel"
        );

        TriviaQuestion q86 = new TriviaQuestion(
                "2023 yılında Türkiye'nin en çok ihraç ettiği ürün hangisidir?",
                "A) Otomotiv",
                "B) Tekstil",
                "C) Hububat",
                "D) Demir-Çelik",
                "E) Mobilya",
                "A) Otomotiv",
                "Güncel"
        );

        TriviaQuestion q87 = new TriviaQuestion(
                "2023 yılı itibarıyla Türkiye'nin nüfusu kaç milyona ulaşmıştır?",
                "A) 80 milyon",
                "B) 83 milyon",
                "C) 86 milyon",
                "D) 90 milyon",
                "E) 95 milyon",
                "C) 86 milyon",
                "Güncel"
        );

        TriviaQuestion q88 = new TriviaQuestion(
                "2023 yılında Türkiye'nin ev sahipliği yaptığı uluslararası organizasyonlardan biri hangisidir?",
                "A) G20 Zirvesi",
                "B) NATO Zirvesi",
                "C) Teknofest Havacılık ve Uzay Festivali",
                "D) Dünya Kupası",
                "E) Cannes Film Festivali",
                "C) Teknofest Havacılık ve Uzay Festivali",
                "Güncel"
        );

        TriviaQuestion q89 = new TriviaQuestion(
                "2023 yılında Türkiye'nin en büyük doğal gaz keşfi hangi bölgede yapılmıştır?",
                "A) Trakya",
                "B) Doğu Anadolu",
                "C) Karadeniz",
                "D) Akdeniz",
                "E) Güneydoğu Anadolu",
                "C) Karadeniz",
                "Güncel"
        );

        TriviaQuestion q90 = new TriviaQuestion(
                "2023 yılında Türkiye'de hizmete giren en uzun tünel hangisidir?",
                "A) Bolu Dağı Tüneli",
                "B) Zigana Tüneli",
                "C) Avrasya Tüneli",
                "D) Ovit Tüneli",
                "E) Ilgaz Tüneli",
                "B) Zigana Tüneli",
                "Güncel"
        );
        TriviaQuestion q91 = new TriviaQuestion(
                "2023 yılında Türkiye'de açılan en büyük teknoloji üssü hangi ilde bulunmaktadır?",
                "A) İstanbul",
                "B) Ankara",
                "C) İzmir",
                "D) Bursa",
                "E) Konya",
                "B) Ankara",
                "Güncel"
        );

        TriviaQuestion q92 = new TriviaQuestion(
                "2023 yılında Türkiye'nin en çok turist çeken şehri hangisidir?",
                "A) Antalya",
                "B) İstanbul",
                "C) İzmir",
                "D) Muğla",
                "E) Kapadokya",
                "B) İstanbul",
                "Güncel"
        );

        TriviaQuestion q93 = new TriviaQuestion(
                "2023 yılında Türkiye'nin ev sahipliği yaptığı en büyük spor organizasyonu hangisidir?",
                "A) Formula 1",
                "B) UEFA Süper Kupa Finali",
                "C) Basketbol Avrupa Şampiyonası",
                "D) Dünya Ralli Şampiyonası",
                "E) Avrupa Voleybol Şampiyonası",
                "E) Avrupa Voleybol Şampiyonası",
                "Güncel"
        );

        TriviaQuestion q94 = new TriviaQuestion(
                "2023 yılı itibarıyla en fazla dış ticaret hacmine sahip ülke hangisidir?",
                "A) Amerika Birleşik Devletleri",
                "B) Çin",
                "C) Almanya",
                "D) Japonya",
                "E) Hindistan",
                "B) Çin",
                "Güncel"
        );

        TriviaQuestion q95 = new TriviaQuestion(
                "2023 yılında en çok hasılat yapan film hangisidir?",
                "A) Avatar: The Way of Water",
                "B) Oppenheimer",
                "C) Barbie",
                "D) Fast X",
                "E) Guardians of the Galaxy Vol. 3",
                "C) Barbie",
                "Güncel"
        );
        TriviaQuestion q96 = new TriviaQuestion(
                "Türk vatandaşlığı hangi kanunla düzenlenmiştir?",
                "A) Medeni Kanun",
                "B) Türk Vatandaşlık Kanunu",
                "C) Ceza Kanunu",
                "D) İdare Hukuku",
                "E) Anayasa",
                "B) Türk Vatandaşlık Kanunu",
                "Vatandaşlık"
        );

        TriviaQuestion q97 = new TriviaQuestion(
                "Türk vatandaşlığı kazanmanın yollarından biri değildir?",
                "A) Doğumla vatandaşlık",
                "B) Evlenme yoluyla vatandaşlık",
                "C) Uzun süre Türkiye'de ikamet etme",
                "D) Cumhurbaşkanı kararıyla vatandaşlık",
                "E) Miras yoluyla vatandaşlık",
                "E) Miras yoluyla vatandaşlık",
                "Vatandaşlık"
        );

        TriviaQuestion q98 = new TriviaQuestion(
                "Vatandaşlık haklarından biri değildir?",
                "A) Seçme ve seçilme hakkı",
                "B) Eğitim hakkı",
                "C) Vergi ödeme yükümlülüğü",
                "D) Düşünce özgürlüğü",
                "E) Sosyal güvenlik hakkı",
                "C) Vergi ödeme yükümlülüğü",
                "Vatandaşlık"
        );

        TriviaQuestion q99 = new TriviaQuestion(
                "Türk vatandaşlığı hangi durumda kaybedilir?",
                "A) Yabancı bir ülkeye seyahat edildiğinde",
                "B) 10 yıl boyunca Türkiye'ye gelinmediğinde",
                "C) Resmi olarak vatandaşlıktan çıkma başvurusu yapıldığında",
                "D) Türkiye'de 5 yıl boyunca çalışma izni alınmadığında",
                "E) Evlilik yoluyla vatandaşlık kazanıldığında",
                "C) Resmi olarak vatandaşlıktan çıkma başvurusu yapıldığında",
                "Vatandaşlık"
        );

        TriviaQuestion q100 = new TriviaQuestion(
                "Türk vatandaşlığı kazanmanın temel şartlarından biri nedir?",
                "A) 5 yıl boyunca kesintisiz ikamet etmek",
                "B) Türkiye'de bir iş yeri açmak",
                "C) Türkçe bilmek",
                "D) Türkiye'de eğitim almış olmak",
                "E) Türk vatandaşlarıyla arkadaşlık kurmak",
                "A) 5 yıl boyunca kesintisiz ikamet etmek",
                "Vatandaşlık"
        );

        TriviaQuestion q101 = new TriviaQuestion(
                "Türkiye'de çifte vatandaşlık hakkı var mıdır?",
                "A) Hayır, tamamen yasaktır.",
                "B) Evet, ancak her ülke için geçerli değildir.",
                "C) Sadece doğumla Türk vatandaşı olanlara tanınır.",
                "D) Türkiye Cumhurbaşkanı onayı ile mümkündür.",
                "E) Sadece AB vatandaşları için geçerlidir.",
                "B) Evet, ancak her ülke için geçerli değildir.",
                "Vatandaşlık"
        );

        TriviaQuestion q102 = new TriviaQuestion(
                "Türk vatandaşlarının temel sorumluluklarından biri değildir?",
                "A) Vergi vermek",
                "B) Askerlik yapmak",
                "C) Seçimlere katılmak",
                "D) Ülkeye yatırım yapmak",
                "E) Yasalara uymak",
                "D) Ülkeye yatırım yapmak",
                "Vatandaşlık"
        );

        TriviaQuestion q103 = new TriviaQuestion(
                "Türkiye Cumhuriyeti'nde seçme ve seçilme yaşı kaçtır?",
                "A) 16",
                "B) 18",
                "C) 21",
                "D) 25",
                "E) 30",
                "B) 18",
                "Vatandaşlık"
        );

        TriviaQuestion q104 = new TriviaQuestion(
                "Aşağıdakilerden hangisi Türk vatandaşlığının kazanılma yollarından biri değildir?",
                "A) Doğumla vatandaşlık",
                "B) Evlilik yoluyla vatandaşlık",
                "C) Miras yoluyla vatandaşlık",
                "D) Göçmenlik yoluyla vatandaşlık",
                "E) İkamet yoluyla vatandaşlık",
                "C) Miras yoluyla vatandaşlık",
                "Vatandaşlık"
        );

        TriviaQuestion q105 = new TriviaQuestion(
                "Türk vatandaşları için geçerli olan sosyal güvenlik kurumu hangisidir?",
                "A) SSK",
                "B) Bağ-Kur",
                "C) SGK",
                "D) Emekli Sandığı",
                "E) Özel Sigorta",
                "Vatandaşlık"
        );
        TriviaQuestion q106 = new TriviaQuestion(
                "Türkiye'nin matematik konumu göz önüne alındığında hangi özellik yanlıştır?",
                "A) 36°-42° kuzey paralelleri arasında yer alır.",
                "B) Orta kuşakta bulunur.",
                "C) Dört mevsim belirgin olarak yaşanır.",
                "D) Aynı anda iki farklı mevsim yaşanmaz.",
                "E) Güneş ışınlarını hiçbir zaman dik açıyla almaz.",
                "D) Aynı anda iki farklı mevsim yaşanmaz.",
                "Coğrafya"
        );

        TriviaQuestion q107 = new TriviaQuestion(
                "Türkiye'de karasal iklimin en belirgin olduğu bölge hangisidir?",
                "A) Ege Bölgesi",
                "B) İç Anadolu Bölgesi",
                "C) Akdeniz Bölgesi",
                "D) Karadeniz Bölgesi",
                "E) Marmara Bölgesi",
                "B) İç Anadolu Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q108 = new TriviaQuestion(
                "Türkiye'nin en fazla yağış alan bölgesi hangisidir?",
                "A) Karadeniz Bölgesi",
                "B) Akdeniz Bölgesi",
                "C) Doğu Anadolu Bölgesi",
                "D) Marmara Bölgesi",
                "E) İç Anadolu Bölgesi",
                "A) Karadeniz Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q109 = new TriviaQuestion(
                "Türkiye'de dağların kıyıya paralel uzandığı bölgelerde hangi özellik gözlenmez?",
                "A) Kıyı ile iç kesimler arasındaki sıcaklık farkı fazladır.",
                "B) Ulaşım zorlaşmıştır.",
                "C) Boyuna kıyı tipi yaygındır.",
                "D) Akarsuların taşıdığı alüvyonlar geniş delta ovaları oluşturmuştur.",
                "E) Yamaç yağışları fazladır.",
                "D) Akarsuların taşıdığı alüvyonlar geniş delta ovaları oluşturmuştur.",
                "Coğrafya"
        );

        TriviaQuestion q110 = new TriviaQuestion(
                "Türkiye'deki en büyük volkanik dağ hangisidir?",
                "A) Erciyes Dağı",
                "B) Nemrut Dağı",
                "C) Ağrı Dağı",
                "D) Süphan Dağı",
                "E) Hasan Dağı",
                "C) Ağrı Dağı",
                "Coğrafya"
        );

        TriviaQuestion q111 = new TriviaQuestion(
                "Ege Bölgesi'nin kıyı kesiminde görülen iklim tipi aşağıdakilerden hangisidir?",
                "A) Karasal İklim",
                "B) Akdeniz İklimi",
                "C) Karadeniz İklimi",
                "D) Step İklimi",
                "E) Muson İklimi",
                "B) Akdeniz İklimi",
                "Coğrafya"
        );

        TriviaQuestion q112 = new TriviaQuestion(
                "Türkiye'nin en uzun akarsuyu hangisidir?",
                "A) Kızılırmak",
                "B) Sakarya Nehri",
                "C) Fırat Nehri",
                "D) Yeşilırmak",
                "E) Dicle Nehri",
                "A) Kızılırmak",
                "Coğrafya"
        );

        TriviaQuestion q113 = new TriviaQuestion(
                "Aşağıdaki göllerden hangisi volkanik kökenlidir?",
                "A) Van Gölü",
                "B) Tuz Gölü",
                "C) Manyas Gölü",
                "D) Eğirdir Gölü",
                "E) Ulubat Gölü",
                "A) Van Gölü",
                "Coğrafya"
        );

        TriviaQuestion q114 = new TriviaQuestion(
                "Aşağıdaki illerden hangisi nüfus yoğunluğu bakımından Türkiye ortalamasının altındadır?",
                "A) İstanbul",
                "B) Ankara",
                "C) İzmir",
                "D) Tunceli",
                "E) Bursa",
                "D) Tunceli",
                "Coğrafya"
        );

        TriviaQuestion q115 = new TriviaQuestion(
                "Türkiye'de nüfusun en az olduğu bölge hangisidir?",
                "A) Ege Bölgesi",
                "B) Marmara Bölgesi",
                "C) Karadeniz Bölgesi",
                "D) Doğu Anadolu Bölgesi",
                "E) Akdeniz Bölgesi",
                "D) Doğu Anadolu Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q116 = new TriviaQuestion(
                "Aşağıdaki ovalardan hangisi delta ovası değildir?",
                "A) Çukurova",
                "B) Bafra Ovası",
                "C) Konya Ovası",
                "D) Menemen Ovası",
                "E) Sakarya Ovası",
                "C) Konya Ovası",
                "Coğrafya"
        );

        TriviaQuestion q117 = new TriviaQuestion(
                "Türkiye'de orman varlığı en fazla olan bölge hangisidir?",
                "A) İç Anadolu Bölgesi",
                "B) Ege Bölgesi",
                "C) Marmara Bölgesi",
                "D) Akdeniz Bölgesi",
                "E) Karadeniz Bölgesi",
                "E) Karadeniz Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q118 = new TriviaQuestion(
                "Türkiye'de en fazla göç alan bölge hangisidir?",
                "A) Karadeniz Bölgesi",
                "B) Marmara Bölgesi",
                "C) Ege Bölgesi",
                "D) Doğu Anadolu Bölgesi",
                "E) İç Anadolu Bölgesi",
                "B) Marmara Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q119 = new TriviaQuestion(
                "Aşağıdakilerden hangisi Türkiye’de en fazla yetiştirilen tarım ürünlerinden biridir?",
                "A) Muz",
                "B) Pamuk",
                "C) Çay",
                "D) Buğday",
                "E) Fındık",
                "D) Buğday",
                "Coğrafya"
        );

        TriviaQuestion q120 = new TriviaQuestion(
                "Türkiye'de sanayileşmenin en fazla olduğu bölge hangisidir?",
                "A) Doğu Anadolu Bölgesi",
                "B) İç Anadolu Bölgesi",
                "C) Marmara Bölgesi",
                "D) Karadeniz Bölgesi",
                "E) Güneydoğu Anadolu Bölgesi",
                "C) Marmara Bölgesi",
                "Coğrafya"
        );

        TriviaQuestion q121 = new TriviaQuestion(
                "Türkiye’de en fazla kullanılan yenilenebilir enerji kaynağı hangisidir?",
                "A) Güneş enerjisi",
                "B) Jeotermal enerji",
                "C) Hidroelektrik enerji",
                "D) Rüzgar enerjisi",
                "E) Biyokütle enerjisi",
                "C) Hidroelektrik enerji",
                "Coğrafya"
        );

        TriviaQuestion q122 = new TriviaQuestion(
                "Türkiye'de heyelan en fazla hangi bölgede görülür?",
                "A) Akdeniz Bölgesi",
                "B) İç Anadolu Bölgesi",
                "C) Ege Bölgesi",
                "D) Karadeniz Bölgesi",
                "E) Marmara Bölgesi",
                "D) Karadeniz Bölgesi",
                "Coğrafya"
        );

// Soruları ekleyelim
        addQuestions(q1);
        addQuestions(q2);
        addQuestions(q3);
        addQuestions(q4);
        addQuestions(q5);
        addQuestions(q6);
        addQuestions(q7);
        addQuestions(q8);
        addQuestions(q9);
        addQuestions(q10);
        addQuestions(q11);
        addQuestions(q12);
        addQuestions(q13);
        addQuestions(q14);
        addQuestions(q15);
        addQuestions(q16);
        addQuestions(q17);
        addQuestions(q18);
        addQuestions(q19);
        addQuestions(q20);
        addQuestions(q21);
        addQuestions(q22);
        addQuestions(q23);
        addQuestions(q24);
        addQuestions(q25);
        addQuestions(q26);
        addQuestions(q27);
        addQuestions(q28);
        addQuestions(q29);
        addQuestions(q30);
        addQuestions(q31);
        addQuestions(q32);
        addQuestions(q33);
        addQuestions(q34);
        addQuestions(q35);
        addQuestions(q36);
        addQuestions(q37);
        addQuestions(q38);
        addQuestions(q39);
        addQuestions(q40);
        addQuestions(q41);
        addQuestions(q42);
        addQuestions(q43);
        addQuestions(q44);
        addQuestions(q45);
        addQuestions(q46);
        addQuestions(q47);
        addQuestions(q48);
        addQuestions(q49);
        addQuestions(q50);
        addQuestions(q51);
        addQuestions(q52);
        addQuestions(q53);
        addQuestions(q54);
        addQuestions(q55);
        addQuestions(q56);
        addQuestions(q57);
        addQuestions(q58);
        addQuestions(q59);
        addQuestions(q60);
        addQuestions(q61);
        addQuestions(q62);
        addQuestions(q63);
        addQuestions(q64);
        addQuestions(q65);
        addQuestions(q66);
        addQuestions(q67);
        addQuestions(q68);
        addQuestions(q69);
        addQuestions(q70);
        addQuestions(q71);
        addQuestions(q72);
        addQuestions(q73);
        addQuestions(q74);
        addQuestions(q75);
        addQuestions(q76);
        addQuestions(q77);
        addQuestions(q78);
        addQuestions(q79);
        addQuestions(q80);
        addQuestions(q81);
        addQuestions(q82);
        addQuestions(q83);
        addQuestions(q84);
        addQuestions(q85);
        addQuestions(q86);
        addQuestions(q87);
        addQuestions(q88);
        addQuestions(q89);
        addQuestions(q90);
        addQuestions(q91);
        addQuestions(q92);
        addQuestions(q93);
        addQuestions(q94);
        addQuestions(q95);
        addQuestions(q96);
        addQuestions(q97);
        addQuestions(q98);
        addQuestions(q99);
        addQuestions(q100);
        addQuestions(q101);
        addQuestions(q102);
        addQuestions(q103);
        addQuestions(q104);
        addQuestions(q105);
        addQuestions(q106);
        addQuestions(q107);
        addQuestions(q108);
        addQuestions(q109);
        addQuestions(q110);
        addQuestions(q111);
        addQuestions(q112);
        addQuestions(q113);
        addQuestions(q114);
        addQuestions(q115);
        addQuestions(q116);
        addQuestions(q117);
        addQuestions(q118);
        addQuestions(q119);
        addQuestions(q120);
        addQuestions(q121);
        addQuestions(q122);


    }

    @SuppressLint("Range")
    public ArrayList<TriviaQuestion> getAllQuestions(String category) {
        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();  // Veritabanı bağlantısını aç

        String[] projection = {
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_OPTION5,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY
        };

        // WHERE koşulu ile sadece belirli kategoriyi çekiyoruz
        String selection = QuestionTable.COLUMN_CATEGORY + " = ?";
        String[] selectionArgs = { category };

        Cursor c = db.query(
                QuestionTable.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                TriviaQuestion question = new TriviaQuestion("Aşağıdaki cümlelerin hangisinde yazım yanlışı vardır?", "A) Bugün hava çok güzel.", "B) Yarın ki toplantıya katılacağım.", "C) Kitapları masaya koy.", "D) Onunla konuşmalısın.", "E) Bu soruyu okuyalım", "B) Yarın ki toplantıya katılacağım.");
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setOption5(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION5)));
                question.setAnswer_nr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR))); // int olarak alındı
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close(); // Cursor kapatıldı
        db.close(); // Veritabanı bağlantısı kapatıldı
        return questionList;
    }
    @SuppressLint("Range")
    public ArrayList<TriviaQuestion> getAllQuestion() {
        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(cursor.getString(cursor.getColumnIndex("question")));
                question.setOption1(cursor.getString(cursor.getColumnIndex("option1")));
                question.setOption2(cursor.getString(cursor.getColumnIndex("option2")));
                question.setOption3(cursor.getString(cursor.getColumnIndex("option3")));
                question.setOption4(cursor.getString(cursor.getColumnIndex("option4")));
                question.setOption5(cursor.getString(cursor.getColumnIndex("option5")));
                question.setAnswer_nr(cursor.getString(cursor.getColumnIndex("answer_nr")));

                questionList.add(question);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return questionList;
    }



}



