package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.MediaSessionCompat.QueueItem;
import android.support.p000v4.media.session.MediaSessionCompat.ResultReceiverWrapper;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: android.support.v4.media.session.IMediaSession */
public interface IMediaSession extends IInterface {

    /* renamed from: android.support.v4.media.session.IMediaSession$Stub */
    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 31;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 32;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getSessionInfo = 50;
        static final int TRANSACTION_getShuffleMode = 47;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isCaptioningEnabled = 45;
        static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_rateWithExtras = 51;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setCaptioningEnabled = 46;
        static final int TRANSACTION_setPlaybackSpeed = 49;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleMode = 48;
        static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        /* renamed from: android.support.v4.media.session.IMediaSession$Stub$Proxy */
        private static class Proxy implements IMediaSession {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiverWrapper != null) {
                        obtain.writeInt(1);
                        resultReceiverWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPackageName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getFlags() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void adjustVolume(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVolumeTo(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<QueueItem> getQueue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(QueueItem.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CharSequence getQueueTitle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getRatingType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isCaptioningEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getRepeatMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getShuffleMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeQueueItemAt(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSessionInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void prepare() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void play() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void skipToQueueItem(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void next() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void previous() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void fastForward() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void rewind() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void seekTo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlaybackSpeed(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRepeatMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setShuffleMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaSession)) {
                return new Proxy(iBinder);
            }
            return (IMediaSession) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v1, types: [android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper] */
        /* JADX WARNING: type inference failed for: r3v3, types: [android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper] */
        /* JADX WARNING: type inference failed for: r3v4, types: [android.view.KeyEvent] */
        /* JADX WARNING: type inference failed for: r3v6, types: [android.view.KeyEvent] */
        /* JADX WARNING: type inference failed for: r3v7, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v9, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v10, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v12, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v13, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v15, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v16, types: [android.support.v4.media.RatingCompat] */
        /* JADX WARNING: type inference failed for: r3v18, types: [android.support.v4.media.RatingCompat] */
        /* JADX WARNING: type inference failed for: r3v19, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v21, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v22, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v24, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v25, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v27, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v28, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v30, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v31, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v33, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v34, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v36, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v37, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v39, types: [android.support.v4.media.MediaDescriptionCompat] */
        /* JADX WARNING: type inference failed for: r3v40, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v42, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v43 */
        /* JADX WARNING: type inference failed for: r3v44 */
        /* JADX WARNING: type inference failed for: r3v45 */
        /* JADX WARNING: type inference failed for: r3v46 */
        /* JADX WARNING: type inference failed for: r3v47 */
        /* JADX WARNING: type inference failed for: r3v48 */
        /* JADX WARNING: type inference failed for: r3v49 */
        /* JADX WARNING: type inference failed for: r3v50 */
        /* JADX WARNING: type inference failed for: r3v51 */
        /* JADX WARNING: type inference failed for: r3v52 */
        /* JADX WARNING: type inference failed for: r3v53 */
        /* JADX WARNING: type inference failed for: r3v54 */
        /* JADX WARNING: type inference failed for: r3v55 */
        /* JADX WARNING: type inference failed for: r3v56 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v43
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.Bundle]
  uses: [android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper, android.os.Bundle]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
        /* JADX WARNING: Unknown variable types count: 27 */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
            r4 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r1 = 1
            java.lang.String r2 = "android.support.v4.media.session.IMediaSession"
            if (r5 == r0) goto L_0x0413
            r0 = 0
            r3 = 0
            switch(r5) {
                case 1: goto L_0x03e6;
                case 2: goto L_0x03c9;
                case 3: goto L_0x03b7;
                case 4: goto L_0x03a5;
                case 5: goto L_0x0397;
                case 6: goto L_0x0389;
                case 7: goto L_0x037b;
                case 8: goto L_0x0364;
                case 9: goto L_0x0356;
                case 10: goto L_0x033f;
                case 11: goto L_0x0329;
                case 12: goto L_0x0313;
                case 13: goto L_0x0309;
                case 14: goto L_0x02ec;
                case 15: goto L_0x02cf;
                case 16: goto L_0x02a6;
                case 17: goto L_0x0298;
                case 18: goto L_0x028e;
                case 19: goto L_0x0284;
                case 20: goto L_0x027a;
                case 21: goto L_0x0270;
                case 22: goto L_0x0266;
                case 23: goto L_0x025c;
                case 24: goto L_0x024e;
                case 25: goto L_0x0235;
                case 26: goto L_0x0218;
                case 27: goto L_0x0201;
                case 28: goto L_0x01ea;
                case 29: goto L_0x01dc;
                case 30: goto L_0x01c5;
                case 31: goto L_0x01ae;
                case 32: goto L_0x01a0;
                case 33: goto L_0x0196;
                case 34: goto L_0x0179;
                case 35: goto L_0x015c;
                case 36: goto L_0x0133;
                case 37: goto L_0x0125;
                case 38: goto L_0x0117;
                case 39: goto L_0x0109;
                case 40: goto L_0x00f8;
                case 41: goto L_0x00df;
                case 42: goto L_0x00c2;
                case 43: goto L_0x00a9;
                case 44: goto L_0x009b;
                case 45: goto L_0x008d;
                case 46: goto L_0x007c;
                case 47: goto L_0x006e;
                case 48: goto L_0x0060;
                case 49: goto L_0x0052;
                case 50: goto L_0x003b;
                case 51: goto L_0x0012;
                default: goto L_0x000d;
            }
        L_0x000d:
            boolean r5 = super.onTransact(r5, r6, r7, r8)
            return r5
        L_0x0012:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x0024
            android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r5 = android.support.p000v4.media.RatingCompat.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            android.support.v4.media.RatingCompat r5 = (android.support.p000v4.media.RatingCompat) r5
            goto L_0x0025
        L_0x0024:
            r5 = r3
        L_0x0025:
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x0034
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0034:
            r4.rateWithExtras(r5, r3)
            r7.writeNoException()
            return r1
        L_0x003b:
            r6.enforceInterface(r2)
            android.os.Bundle r5 = r4.getSessionInfo()
            r7.writeNoException()
            if (r5 == 0) goto L_0x004e
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x0051
        L_0x004e:
            r7.writeInt(r0)
        L_0x0051:
            return r1
        L_0x0052:
            r6.enforceInterface(r2)
            float r5 = r6.readFloat()
            r4.setPlaybackSpeed(r5)
            r7.writeNoException()
            return r1
        L_0x0060:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            r4.setShuffleMode(r5)
            r7.writeNoException()
            return r1
        L_0x006e:
            r6.enforceInterface(r2)
            int r5 = r4.getShuffleMode()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x007c:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x0086
            r0 = 1
        L_0x0086:
            r4.setCaptioningEnabled(r0)
            r7.writeNoException()
            return r1
        L_0x008d:
            r6.enforceInterface(r2)
            boolean r5 = r4.isCaptioningEnabled()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x009b:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            r4.removeQueueItemAt(r5)
            r7.writeNoException()
            return r1
        L_0x00a9:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x00bb
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r5 = android.support.p000v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            r3 = r5
            android.support.v4.media.MediaDescriptionCompat r3 = (android.support.p000v4.media.MediaDescriptionCompat) r3
        L_0x00bb:
            r4.removeQueueItem(r3)
            r7.writeNoException()
            return r1
        L_0x00c2:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x00d4
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r5 = android.support.p000v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            r3 = r5
            android.support.v4.media.MediaDescriptionCompat r3 = (android.support.p000v4.media.MediaDescriptionCompat) r3
        L_0x00d4:
            int r5 = r6.readInt()
            r4.addQueueItemAt(r3, r5)
            r7.writeNoException()
            return r1
        L_0x00df:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x00f1
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r5 = android.support.p000v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            r3 = r5
            android.support.v4.media.MediaDescriptionCompat r3 = (android.support.p000v4.media.MediaDescriptionCompat) r3
        L_0x00f1:
            r4.addQueueItem(r3)
            r7.writeNoException()
            return r1
        L_0x00f8:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x0102
            r0 = 1
        L_0x0102:
            r4.setShuffleModeEnabledRemoved(r0)
            r7.writeNoException()
            return r1
        L_0x0109:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            r4.setRepeatMode(r5)
            r7.writeNoException()
            return r1
        L_0x0117:
            r6.enforceInterface(r2)
            boolean r5 = r4.isShuffleModeEnabledRemoved()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x0125:
            r6.enforceInterface(r2)
            int r5 = r4.getRepeatMode()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x0133:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x0145
            android.os.Parcelable$Creator r5 = android.net.Uri.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x0146
        L_0x0145:
            r5 = r3
        L_0x0146:
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x0155
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0155:
            r4.prepareFromUri(r5, r3)
            r7.writeNoException()
            return r1
        L_0x015c:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x0172
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0172:
            r4.prepareFromSearch(r5, r3)
            r7.writeNoException()
            return r1
        L_0x0179:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x018f
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x018f:
            r4.prepareFromMediaId(r5, r3)
            r7.writeNoException()
            return r1
        L_0x0196:
            r6.enforceInterface(r2)
            r4.prepare()
            r7.writeNoException()
            return r1
        L_0x01a0:
            r6.enforceInterface(r2)
            int r5 = r4.getRatingType()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x01ae:
            r6.enforceInterface(r2)
            android.os.Bundle r5 = r4.getExtras()
            r7.writeNoException()
            if (r5 == 0) goto L_0x01c1
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x01c4
        L_0x01c1:
            r7.writeInt(r0)
        L_0x01c4:
            return r1
        L_0x01c5:
            r6.enforceInterface(r2)
            java.lang.CharSequence r5 = r4.getQueueTitle()
            r7.writeNoException()
            if (r5 == 0) goto L_0x01d8
            r7.writeInt(r1)
            android.text.TextUtils.writeToParcel(r5, r7, r1)
            goto L_0x01db
        L_0x01d8:
            r7.writeInt(r0)
        L_0x01db:
            return r1
        L_0x01dc:
            r6.enforceInterface(r2)
            java.util.List r5 = r4.getQueue()
            r7.writeNoException()
            r7.writeTypedList(r5)
            return r1
        L_0x01ea:
            r6.enforceInterface(r2)
            android.support.v4.media.session.PlaybackStateCompat r5 = r4.getPlaybackState()
            r7.writeNoException()
            if (r5 == 0) goto L_0x01fd
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x0200
        L_0x01fd:
            r7.writeInt(r0)
        L_0x0200:
            return r1
        L_0x0201:
            r6.enforceInterface(r2)
            android.support.v4.media.MediaMetadataCompat r5 = r4.getMetadata()
            r7.writeNoException()
            if (r5 == 0) goto L_0x0214
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x0217
        L_0x0214:
            r7.writeInt(r0)
        L_0x0217:
            return r1
        L_0x0218:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x022e
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x022e:
            r4.sendCustomAction(r5, r3)
            r7.writeNoException()
            return r1
        L_0x0235:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x0247
            android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r5 = android.support.p000v4.media.RatingCompat.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            r3 = r5
            android.support.v4.media.RatingCompat r3 = (android.support.p000v4.media.RatingCompat) r3
        L_0x0247:
            r4.rate(r3)
            r7.writeNoException()
            return r1
        L_0x024e:
            r6.enforceInterface(r2)
            long r5 = r6.readLong()
            r4.seekTo(r5)
            r7.writeNoException()
            return r1
        L_0x025c:
            r6.enforceInterface(r2)
            r4.rewind()
            r7.writeNoException()
            return r1
        L_0x0266:
            r6.enforceInterface(r2)
            r4.fastForward()
            r7.writeNoException()
            return r1
        L_0x0270:
            r6.enforceInterface(r2)
            r4.previous()
            r7.writeNoException()
            return r1
        L_0x027a:
            r6.enforceInterface(r2)
            r4.next()
            r7.writeNoException()
            return r1
        L_0x0284:
            r6.enforceInterface(r2)
            r4.stop()
            r7.writeNoException()
            return r1
        L_0x028e:
            r6.enforceInterface(r2)
            r4.pause()
            r7.writeNoException()
            return r1
        L_0x0298:
            r6.enforceInterface(r2)
            long r5 = r6.readLong()
            r4.skipToQueueItem(r5)
            r7.writeNoException()
            return r1
        L_0x02a6:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x02b8
            android.os.Parcelable$Creator r5 = android.net.Uri.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x02b9
        L_0x02b8:
            r5 = r3
        L_0x02b9:
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x02c8
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x02c8:
            r4.playFromUri(r5, r3)
            r7.writeNoException()
            return r1
        L_0x02cf:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x02e5
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x02e5:
            r4.playFromSearch(r5, r3)
            r7.writeNoException()
            return r1
        L_0x02ec:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x0302
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r6 = r8.createFromParcel(r6)
            r3 = r6
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0302:
            r4.playFromMediaId(r5, r3)
            r7.writeNoException()
            return r1
        L_0x0309:
            r6.enforceInterface(r2)
            r4.play()
            r7.writeNoException()
            return r1
        L_0x0313:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            int r8 = r6.readInt()
            java.lang.String r6 = r6.readString()
            r4.setVolumeTo(r5, r8, r6)
            r7.writeNoException()
            return r1
        L_0x0329:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            int r8 = r6.readInt()
            java.lang.String r6 = r6.readString()
            r4.adjustVolume(r5, r8, r6)
            r7.writeNoException()
            return r1
        L_0x033f:
            r6.enforceInterface(r2)
            android.support.v4.media.session.ParcelableVolumeInfo r5 = r4.getVolumeAttributes()
            r7.writeNoException()
            if (r5 == 0) goto L_0x0352
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x0355
        L_0x0352:
            r7.writeInt(r0)
        L_0x0355:
            return r1
        L_0x0356:
            r6.enforceInterface(r2)
            long r5 = r4.getFlags()
            r7.writeNoException()
            r7.writeLong(r5)
            return r1
        L_0x0364:
            r6.enforceInterface(r2)
            android.app.PendingIntent r5 = r4.getLaunchPendingIntent()
            r7.writeNoException()
            if (r5 == 0) goto L_0x0377
            r7.writeInt(r1)
            r5.writeToParcel(r7, r1)
            goto L_0x037a
        L_0x0377:
            r7.writeInt(r0)
        L_0x037a:
            return r1
        L_0x037b:
            r6.enforceInterface(r2)
            java.lang.String r5 = r4.getTag()
            r7.writeNoException()
            r7.writeString(r5)
            return r1
        L_0x0389:
            r6.enforceInterface(r2)
            java.lang.String r5 = r4.getPackageName()
            r7.writeNoException()
            r7.writeString(r5)
            return r1
        L_0x0397:
            r6.enforceInterface(r2)
            boolean r5 = r4.isTransportControlEnabled()
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x03a5:
            r6.enforceInterface(r2)
            android.os.IBinder r5 = r6.readStrongBinder()
            android.support.v4.media.session.IMediaControllerCallback r5 = android.support.p000v4.media.session.IMediaControllerCallback.Stub.asInterface(r5)
            r4.unregisterCallbackListener(r5)
            r7.writeNoException()
            return r1
        L_0x03b7:
            r6.enforceInterface(r2)
            android.os.IBinder r5 = r6.readStrongBinder()
            android.support.v4.media.session.IMediaControllerCallback r5 = android.support.p000v4.media.session.IMediaControllerCallback.Stub.asInterface(r5)
            r4.registerCallbackListener(r5)
            r7.writeNoException()
            return r1
        L_0x03c9:
            r6.enforceInterface(r2)
            int r5 = r6.readInt()
            if (r5 == 0) goto L_0x03db
            android.os.Parcelable$Creator r5 = android.view.KeyEvent.CREATOR
            java.lang.Object r5 = r5.createFromParcel(r6)
            r3 = r5
            android.view.KeyEvent r3 = (android.view.KeyEvent) r3
        L_0x03db:
            boolean r5 = r4.sendMediaButton(r3)
            r7.writeNoException()
            r7.writeInt(r5)
            return r1
        L_0x03e6:
            r6.enforceInterface(r2)
            java.lang.String r5 = r6.readString()
            int r8 = r6.readInt()
            if (r8 == 0) goto L_0x03fc
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r8.createFromParcel(r6)
            android.os.Bundle r8 = (android.os.Bundle) r8
            goto L_0x03fd
        L_0x03fc:
            r8 = r3
        L_0x03fd:
            int r0 = r6.readInt()
            if (r0 == 0) goto L_0x040c
            android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper> r0 = android.support.p000v4.media.session.MediaSessionCompat.ResultReceiverWrapper.CREATOR
            java.lang.Object r6 = r0.createFromParcel(r6)
            r3 = r6
            android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper r3 = (android.support.p000v4.media.session.MediaSessionCompat.ResultReceiverWrapper) r3
        L_0x040c:
            r4.sendCommand(r5, r8, r3)
            r7.writeNoException()
            return r1
        L_0x0413:
            r7.writeString(r2)
            return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.session.IMediaSession.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException;

    void adjustVolume(int i, int i2, String str) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    Bundle getSessionInfo() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String str, Bundle bundle) throws RemoteException;

    void playFromSearch(String str, Bundle bundle) throws RemoteException;

    void playFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String str, Bundle bundle) throws RemoteException;

    void prepareFromSearch(String str, Bundle bundle) throws RemoteException;

    void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat ratingCompat) throws RemoteException;

    void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void removeQueueItemAt(int i) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long j) throws RemoteException;

    void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void sendCustomAction(String str, Bundle bundle) throws RemoteException;

    boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException;

    void setCaptioningEnabled(boolean z) throws RemoteException;

    void setPlaybackSpeed(float f) throws RemoteException;

    void setRepeatMode(int i) throws RemoteException;

    void setShuffleMode(int i) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean z) throws RemoteException;

    void setVolumeTo(int i, int i2, String str) throws RemoteException;

    void skipToQueueItem(long j) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;
}
