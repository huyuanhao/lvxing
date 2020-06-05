package com.p530ss.android.socialbase.downloader.p569m;

import com.p522qq.p523e.comm.constants.ErrorCode.AdError;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.network.HttpStatus;

/* renamed from: com.ss.android.socialbase.downloader.m.d */
public class DownloadHttpUtils {
    /* renamed from: a */
    public static String m28745a(int i) {
        if (i == 449) {
            return "Retry With";
        }
        if (i == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i == 600) {
            return "Unparseable Response Headers";
        }
        if (i == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i == 510) {
            return "Not Extended";
        }
        switch (i) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i) {
                    case 200:
                        return "OK";
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    case 207:
                        return "Multi-Status";
                    default:
                        switch (i) {
                            case 300:
                                return "Multiple Choices";
                            case 301:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case 305:
                                return "Use Proxy";
                            case TinkerReport.KEY_LOADED_MISSING_PATCH_INFO /*306*/:
                                return "Switch Proxy";
                            case 307:
                                return "Temporary Redirect";
                            default:
                                switch (i) {
                                    case 400:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case HttpStatus.SC_REQUEST_TIMEOUT /*408*/:
                                        return "Request Timeout";
                                    case HttpStatus.SC_CONFLICT /*409*/:
                                        return "Conflict";
                                    case HttpStatus.SC_GONE /*410*/:
                                        return "Gone";
                                    case HttpStatus.SC_LENGTH_REQUIRED /*411*/:
                                        return "Length Required";
                                    case HttpStatus.SC_PRECONDITION_FAILED /*412*/:
                                        return "Precondition Failed";
                                    case HttpStatus.SC_REQUEST_TOO_LONG /*413*/:
                                        return "Request Entity Too Large";
                                    case HttpStatus.SC_REQUEST_URI_TOO_LONG /*414*/:
                                        return "Request-URI Too Long";
                                    case HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE /*415*/:
                                        return "Unsupported Media Type";
                                    case HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE /*416*/:
                                        return "Requested Range Not Satisfiable";
                                    case HttpStatus.SC_EXPECTATION_FAILED /*417*/:
                                        return "Expectation Failed";
                                    case 418:
                                        return "I'm a teapot";
                                    default:
                                        switch (i) {
                                            case 421:
                                                return "Too Many Connections";
                                            case HttpStatus.SC_UNPROCESSABLE_ENTITY /*422*/:
                                                return "Unprocessable Entity";
                                            case HttpStatus.SC_LOCKED /*423*/:
                                                return "Locked";
                                            case HttpStatus.SC_FAILED_DEPENDENCY /*424*/:
                                                return "Failed Dependency";
                                            case 425:
                                                return "Unordered Collection";
                                            case 426:
                                                return "Upgrade Required";
                                            default:
                                                switch (i) {
                                                    case 500:
                                                        return "Internal Server Error";
                                                    case 501:
                                                        return "Not Implemented";
                                                    case 502:
                                                        return "Bad Gateway";
                                                    case 503:
                                                        return "Service Unavailable";
                                                    case HttpStatus.SC_GATEWAY_TIMEOUT /*504*/:
                                                        return "Gateway Timeout";
                                                    case 505:
                                                        return "HTTP Version Not Supported";
                                                    case AdError.RETRY_LOAD_SUCCESS /*506*/:
                                                        return "Variant Also Negotiates";
                                                    case HttpStatus.SC_INSUFFICIENT_STORAGE /*507*/:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
