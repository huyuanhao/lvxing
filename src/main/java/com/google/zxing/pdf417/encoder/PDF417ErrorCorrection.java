package com.google.zxing.pdf417.encoder;

import androidx.core.app.FrameMetricsAggregator;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import epco.C7990p;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, TinkerReport.KEY_LOADED_MISSING_RES, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, ScreenUtil.M9_WIDTH, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, HttpStatus.SC_GONE}, new int[]{539, HttpStatus.SC_UNPROCESSABLE_ENTITY, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 440, 35, 519, 31, 460, 594, 225, 535, 517, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, OtherError.UNKNOWN_ERROR, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, 822, 93, 217, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, C7990p.f27143h, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, OtherError.CONTAINER_HEIGHT_ERROR, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 732, 95, 270, 447, 90, HttpStatus.SC_INSUFFICIENT_STORAGE, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, OtherError.ANDROID_PERMMISON_ERROR, 754, 336, 89, 614, 87, 432, 670, 616, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 374, 242, 726, OtherError.CONTAINER_INVISIBLE_ERROR, 269, 375, 898, 845, 454, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, OtherError.UNKNOWN_ERROR, 540, 913, 801, OtherError.VIDEO_DOWNLOAD_ERROR, 799, 137, 439, 418, 592, 668, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 859, 370, 694, 325, ScreenUtil.G8_WIDTH, 216, 257, 284, 549, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, OtherError.NETWORK_TYPE_ERROR, 192, OtherError.UNKNOWN_ERROR, 142, 673, 687, 234, 722, C7990p.f27147l, 177, 752, OtherError.NATIVE_FORCE_EXPOSURE, ScreenUtil.M9_WIDTH, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, TinkerReport.KEY_APPLIED_VERSION_CHECK, 791, 893, 754, OtherError.UNKNOWN_ERROR, C7990p.f27146k, 228, 749, 760, ScreenUtil.N7_DENSITY, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 77, 373, HttpStatus.SC_GATEWAY_TIMEOUT, 35, 599, 428, 207, HttpStatus.SC_CONFLICT, 574, 118, 498, 285, 380, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 492, 197, 265, 920, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 914, 299, 229, 643, 294, 871, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 88, 87, 193, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, ScreenUtil.M9_WIDTH, 268, 794, 534, 539, 781, HttpStatus.SC_REQUEST_TIMEOUT, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, C7990p.f27146k, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, TinkerReport.KEY_APPLIED_VERSION_CHECK, 20, 297, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, C7990p.f27143h, ScreenUtil.G8_WIDTH, 518, 794, 395, 768, 848, 51, 610, C7990p.f27147l, 168, 190, 826, 328, 596, 786, 303, 570, 381, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, 641, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 237, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 785, 288, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, HttpStatus.SC_METHOD_FAILURE, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, HttpStatus.SC_REQUEST_TIMEOUT, 842, C7990p.f27146k, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, HttpStatus.SC_EXPECTATION_FAILED, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 563, 564, 343, 693, 109, OtherError.SKIP_VIEW_SIZE_ERROR, 563, 365, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 772, 677, 310, 248, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 708, HttpStatus.SC_GONE, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, HttpStatus.SC_FAILED_DEPENDENCY, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, HttpStatus.SC_METHOD_FAILURE, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, TinkerReport.KEY_LOADED_MISSING_RES, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, HttpStatus.SC_UNPROCESSABLE_ENTITY, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 923, 116, 667, 751, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 62, 366, 691, 379, 687, 842, 37, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 720, 742, 330, 5, 39, 923, 311, HttpStatus.SC_FAILED_DEPENDENCY, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, ScreenUtil.M9_WIDTH, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, HttpStatus.SC_LENGTH_REQUIRED, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, OtherError.CONTAINER_INVISIBLE_ERROR, 325, 498, 655, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 752, 768, 223, 849, 647, 63, 310, 863, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 366, 304, 282, 738, 675, HttpStatus.SC_GONE, 389, 244, 31, 121, 303, 263}};

    private PDF417ErrorCorrection() {
    }

    static int getErrorCorrectionCodewordCount(int i) {
        if (i >= 0 && i <= 8) {
            return 1 << (i + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i <= 40) {
            return 2;
        } else {
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }

    static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }
}
