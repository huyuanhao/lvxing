package mtopsdk.mtop.features;

public final class MtopFeatureManager {

    /* renamed from: mtopsdk.mtop.features.MtopFeatureManager$MtopFeatureEnum */
    public enum MtopFeatureEnum {
        SUPPORT_RELATIVE_URL(1),
        UNIT_INFO_FEATURE(2),
        DISABLE_WHITEBOX_SIGN(3),
        SUPPORT_UTDID_UNIT(4),
        DISABLE_X_COMMAND(5),
        SUPPORT_OPEN_ACCOUNT(6);
        
        long feature;

        public final long getFeature() {
            return this.feature;
        }

        private MtopFeatureEnum(long j) {
            this.feature = j;
        }
    }
}
