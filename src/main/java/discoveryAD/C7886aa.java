package discoveryAD;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: discoveryAD.aa */
public class C7886aa implements C7891ca {
    private static final String TAG = "CommonAdDBCreator";
    /* renamed from: Td */
    private static final int f26823Td = 11;
    /* renamed from: Zd */
    public static final String f26824Zd = "common_advertise_table";

    /* renamed from: discoveryAD.aa$a */
    interface C7887a {
        /* renamed from: Ah */
        public static final String f26825Ah = "effective_time";
        /* renamed from: Bh */
        public static final String f26826Bh = "continuousExposureTime";
        public static final String CONTENT_TYPE = "content_type";
        /* renamed from: Ch */
        public static final String f26827Ch = "exposureInterval";
        /* renamed from: Dh */
        public static final String f26828Dh = "scenes";
        /* renamed from: Eh */
        public static final String f26829Eh = "predisplaytime";
        /* renamed from: Fh */
        public static final String f26830Fh = "videoUrl";
        /* renamed from: Gh */
        public static final String f26831Gh = "zipUrl";
        /* renamed from: Hh */
        public static final String f26832Hh = "appDownloadUrl";
        /* renamed from: ID */
        public static final String f26833ID = "_id";
        /* renamed from: Ih */
        public static final String f26834Ih = "isAutoAppDownload";
        /* renamed from: Jh */
        public static final String f26835Jh = "isdeeplink";
        /* renamed from: Kh */
        public static final String f26836Kh = "desttype";
        /* renamed from: Lh */
        public static final String f26837Lh = "customedurl";
        /* renamed from: Mh */
        public static final String f26838Mh = "channelId";
        /* renamed from: Nh */
        public static final String f26839Nh = "displayinvipmode";
        /* renamed from: Oh */
        public static final String f26840Oh = "imgscombine";
        /* renamed from: Ph */
        public static final String f26841Ph = "extra_data_type";
        /* renamed from: Qh */
        public static final String f26842Qh = "extraDataJSON";
        public static final String ROTATION = "rotation";
        /* renamed from: Rh */
        public static final String f26843Rh = "exposureTrackUrls";
        /* renamed from: Sh */
        public static final String f26844Sh = "clickTrackUrls";
        /* renamed from: Th */
        public static final String f26845Th = "startDownloadTrackUrls";
        /* renamed from: Uh */
        public static final String f26846Uh = "finishDownloadTrackUrls";
        /* renamed from: Vh */
        public static final String f26847Vh = "closeTrackUrls";
        public static final String WEIGHT = "weight";
        /* renamed from: Wh */
        public static final String f26848Wh = "videoPlayBeginTrackUrls";
        /* renamed from: Xh */
        public static final String f26849Xh = "videoPlayEndTrackUrls";
        /* renamed from: Yh */
        public static final String f26850Yh = "videoPlay25TrackUrls";
        /* renamed from: Zh */
        public static final String f26851Zh = "videoPlay50TrackUrls";
        /* renamed from: _h */
        public static final String f26852_h = "videoPlay75TrackUrls";
        /* renamed from: ai */
        public static final String f26853ai = "installedTrackUrls";
        /* renamed from: ch */
        public static final String f26854ch = "activity_id";
        /* renamed from: eh */
        public static final String f26855eh = "context";
        /* renamed from: hh */
        public static final String f26856hh = "uniquekey";
        /* renamed from: ih */
        public static final String f26857ih = "ad_phase";
        /* renamed from: jh */
        public static final String f26858jh = "is_shareable";
        /* renamed from: kh */
        public static final String f26859kh = "pos_id";
        /* renamed from: lh */
        public static final String f26860lh = "template_type";
        /* renamed from: mh */
        public static final String f26861mh = "text1";
        /* renamed from: nh */
        public static final String f26862nh = "text2";
        /* renamed from: oh */
        public static final String f26863oh = "text3";
        /* renamed from: ph */
        public static final String f26864ph = "image_url1";
        /* renamed from: qh */
        public static final String f26865qh = "image_url2";
        /* renamed from: rh */
        public static final String f26866rh = "image_url3";
        /* renamed from: sh */
        public static final String f26867sh = "jump_url";
        /* renamed from: th */
        public static final String f26868th = "packagename";
        /* renamed from: uh */
        public static final String f26869uh = "expire_time";
        /* renamed from: vh */
        public static final String f26870vh = "max_display_time";
        /* renamed from: wh */
        public static final String f26871wh = "max_click_time";
        /* renamed from: xh */
        public static final String f26872xh = "text4";
        /* renamed from: yh */
        public static final String f26873yh = "persentspent";
        /* renamed from: zh */
        public static final String f26874zh = "jump_type";
    }

    /* renamed from: a */
    private void m34284a(SQLiteDatabase sQLiteDatabase) {
        C7852Aa.m34154d(TAG, "CREATE_GAME_LIST_DB_SQL:CREATE TABLE IF NOT EXISTS common_advertise_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,jump_type INTEGER,persentspent INTEGER,uniquekey TEXT,ad_phase INTEGER,is_shareable TEXT,pos_id INTEGER,activity_id TEXT,template_type INTEGER,text1 TEXT,text2 TEXT,text3 TEXT,text4 TEXT,image_url1 TEXT,image_url2 TEXT,image_url3 TEXT,content_type INTEGER,jump_url TEXT,packagename TEXT,expire_time INTEGER,context BLOB,max_display_time INTEGER,max_click_time INTEGER,effective_time INTEGER,continuousExposureTime INTEGER,exposureInterval INTEGER,scenes INTEGER,weight INTEGER,predisplaytime INTEGER,videoUrl TEXT,zipUrl TEXT,isAutoAppDownload INTEGER,appDownloadUrl TEXT,isdeeplink INTEGER,rotation INTEGER,desttype INTEGER,customedurl TEXT,channelId TEXT,displayinvipmode INTEGER,extra_data_type INTEGER,extraDataJSON TEXT,exposureTrackUrls TEXT,clickTrackUrls TEXT,startDownloadTrackUrls TEXT,finishDownloadTrackUrls TEXT,closeTrackUrls TEXT,videoPlayBeginTrackUrls TEXT,videoPlayEndTrackUrls TEXT,videoPlay25TrackUrls TEXT,videoPlay50TrackUrls TEXT,videoPlay75TrackUrls TEXT,installedTrackUrls TEXT,imgscombine TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS common_advertise_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,jump_type INTEGER,persentspent INTEGER,uniquekey TEXT,ad_phase INTEGER,is_shareable TEXT,pos_id INTEGER,activity_id TEXT,template_type INTEGER,text1 TEXT,text2 TEXT,text3 TEXT,text4 TEXT,image_url1 TEXT,image_url2 TEXT,image_url3 TEXT,content_type INTEGER,jump_url TEXT,packagename TEXT,expire_time INTEGER,context BLOB,max_display_time INTEGER,max_click_time INTEGER,effective_time INTEGER,continuousExposureTime INTEGER,exposureInterval INTEGER,scenes INTEGER,weight INTEGER,predisplaytime INTEGER,videoUrl TEXT,zipUrl TEXT,isAutoAppDownload INTEGER,appDownloadUrl TEXT,isdeeplink INTEGER,rotation INTEGER,desttype INTEGER,customedurl TEXT,channelId TEXT,displayinvipmode INTEGER,extra_data_type INTEGER,extraDataJSON TEXT,exposureTrackUrls TEXT,clickTrackUrls TEXT,startDownloadTrackUrls TEXT,finishDownloadTrackUrls TEXT,closeTrackUrls TEXT,videoPlayBeginTrackUrls TEXT,videoPlayEndTrackUrls TEXT,videoPlay25TrackUrls TEXT,videoPlay50TrackUrls TEXT,videoPlay75TrackUrls TEXT,installedTrackUrls TEXT,imgscombine TEXT)");
    }

    /* renamed from: b */
    private void m34285b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS common_advertise_table");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m34285b(sQLiteDatabase);
        m34284a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m34285b(sQLiteDatabase);
        m34284a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            m34285b(sQLiteDatabase);
            m34284a(sQLiteDatabase);
            return;
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN isAutoAppDownload INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN appDownloadUrl TEXT");
        }
        if (i < 6) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN isdeeplink INTEGER");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i < 7) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN rotation INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN desttype INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN customedurl TEXT");
        }
        if (i < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN channelId TEXT");
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN displayinvipmode INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN imgscombine TEXT");
        }
        if (i < 10) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN extra_data_type INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN extraDataJSON TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN exposureTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN clickTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN startDownloadTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN finishDownloadTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN closeTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN videoPlayBeginTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN videoPlayEndTrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN videoPlay25TrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN videoPlay50TrackUrls TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN videoPlay75TrackUrls TEXT");
        }
        if (i < 10) {
            sQLiteDatabase.execSQL("ALTER TABLE common_advertise_table ADD COLUMN installedTrackUrls TEXT");
        }
    }

    /* renamed from: u */
    public int mo38161u() {
        return 11;
    }
}
