package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public class IVasAioData {
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class VasAioMsgData {
        static IPatchRedirector $redirector_;
        private int avatarId;
        private int bubbleDiyTextId;
        private int bubbleId;
        private int bubbleVoiceId;
        private int canConvertToText;

        @NotNull
        private ArrayList<Integer> carouselNamePlateIds;
        private int diyFontCfgUpdateTime;
        private int diyFontImageId;
        private int extendNamePlateId;
        private int fontId;
        private int gameNamePlateId;
        private int grayNamePlate;
        private int isIceBreakMsg;
        private int magicFontType;
        private int msgBigClubFlag;
        private int msgBigClubLevel;
        private int msgVipLevel;
        private int msgVipType;
        private int namePlateId;
        private int namePlateType;
        private int pendantDiyInfoId;
        private long pendantId;
        private int subBubbleId;
        private long subFontId;
        private int templateID;
        private int vipStarFlag;

        public VasAioMsgData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
                this.carouselNamePlateIds = new ArrayList<>();
            } else {
                iPatchRedirector.redirect((short) 53, this);
            }
        }

        public int getAvatarId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? this.avatarId : ((Integer) iPatchRedirector.redirect((short) 33, this)).intValue();
        }

        public int getBubbleDiyTextId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? this.bubbleDiyTextId : ((Integer) iPatchRedirector.redirect((short) 25, this)).intValue();
        }

        public int getBubbleId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? this.bubbleId : ((Integer) iPatchRedirector.redirect((short) 23, this)).intValue();
        }

        public int getBubbleVoiceId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) ? this.bubbleVoiceId : ((Integer) iPatchRedirector.redirect((short) 27, this)).intValue();
        }

        public int getCanConvertToText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? this.canConvertToText : ((Integer) iPatchRedirector.redirect((short) 31, this)).intValue();
        }

        @NotNull
        public ArrayList<Integer> getCarouselNamePlateIds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? this.carouselNamePlateIds : (ArrayList) iPatchRedirector.redirect((short) 17, this);
        }

        public int getDiyFontCfgUpdateTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) ? this.diyFontCfgUpdateTime : ((Integer) iPatchRedirector.redirect((short) 43, this)).intValue();
        }

        public int getDiyFontImageId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) ? this.diyFontImageId : ((Integer) iPatchRedirector.redirect((short) 45, this)).intValue();
        }

        public int getExtendNamePlateId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.extendNamePlateId : ((Integer) iPatchRedirector.redirect((short) 19, this)).intValue();
        }

        public int getFontId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) ? this.fontId : ((Integer) iPatchRedirector.redirect((short) 39, this)).intValue();
        }

        public int getGameNamePlateId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.gameNamePlateId : ((Integer) iPatchRedirector.redirect((short) 21, this)).intValue();
        }

        public int getGrayNamePlate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.grayNamePlate : ((Integer) iPatchRedirector.redirect((short) 9, this)).intValue();
        }

        public int getMagicFontType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) ? this.magicFontType : ((Integer) iPatchRedirector.redirect((short) 47, this)).intValue();
        }

        public int getMsgBigClubFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.msgBigClubFlag : ((Integer) iPatchRedirector.redirect((short) 5, this)).intValue();
        }

        public int getMsgBigClubLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.msgBigClubLevel : ((Integer) iPatchRedirector.redirect((short) 7, this)).intValue();
        }

        public int getMsgVipLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.msgVipLevel : ((Integer) iPatchRedirector.redirect((short) 3, this)).intValue();
        }

        public int getMsgVipType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) ? this.msgVipType : ((Integer) iPatchRedirector.redirect((short) 1, this)).intValue();
        }

        public int getNamePlateId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? this.namePlateId : ((Integer) iPatchRedirector.redirect((short) 15, this)).intValue();
        }

        public int getNamePlateType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this.namePlateType : ((Integer) iPatchRedirector.redirect((short) 11, this)).intValue();
        }

        public int getPendantDiyInfoId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) ? this.pendantDiyInfoId : ((Integer) iPatchRedirector.redirect((short) 37, this)).intValue();
        }

        public long getPendantId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) ? this.pendantId : ((Long) iPatchRedirector.redirect((short) 35, this)).longValue();
        }

        public int getSubBubbleId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? this.subBubbleId : ((Integer) iPatchRedirector.redirect((short) 29, this)).intValue();
        }

        public long getSubFontId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) ? this.subFontId : ((Long) iPatchRedirector.redirect((short) 41, this)).longValue();
        }

        public int getTemplateID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) ? this.templateID : ((Integer) iPatchRedirector.redirect((short) 49, this)).intValue();
        }

        public int getVipStarFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.vipStarFlag : ((Integer) iPatchRedirector.redirect((short) 13, this)).intValue();
        }

        public int isIceBreakMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) ? this.isIceBreakMsg : ((Integer) iPatchRedirector.redirect((short) 51, this)).intValue();
        }

        public void setAvatarId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
                this.avatarId = i2;
            } else {
                iPatchRedirector.redirect((short) 34, this, i2);
            }
        }

        public void setBubbleDiyTextId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                this.bubbleDiyTextId = i2;
            } else {
                iPatchRedirector.redirect((short) 26, this, i2);
            }
        }

        public void setBubbleId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                this.bubbleId = i2;
            } else {
                iPatchRedirector.redirect((short) 24, this, i2);
            }
        }

        public void setBubbleVoiceId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
                this.bubbleVoiceId = i2;
            } else {
                iPatchRedirector.redirect((short) 28, this, i2);
            }
        }

        public void setCanConvertToText(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
                this.canConvertToText = i2;
            } else {
                iPatchRedirector.redirect((short) 32, this, i2);
            }
        }

        public void setCarouselNamePlateIds(@NotNull ArrayList<Integer> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, arrayList);
            } else {
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                this.carouselNamePlateIds = arrayList;
            }
        }

        public void setDiyFontCfgUpdateTime(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) {
                this.diyFontCfgUpdateTime = i2;
            } else {
                iPatchRedirector.redirect((short) 44, this, i2);
            }
        }

        public void setDiyFontImageId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 46)) {
                this.diyFontImageId = i2;
            } else {
                iPatchRedirector.redirect((short) 46, this, i2);
            }
        }

        public void setExtendNamePlateId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                this.extendNamePlateId = i2;
            } else {
                iPatchRedirector.redirect((short) 20, this, i2);
            }
        }

        public void setFontId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
                this.fontId = i2;
            } else {
                iPatchRedirector.redirect((short) 40, this, i2);
            }
        }

        public void setGameNamePlateId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                this.gameNamePlateId = i2;
            } else {
                iPatchRedirector.redirect((short) 22, this, i2);
            }
        }

        public void setGrayNamePlate(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                this.grayNamePlate = i2;
            } else {
                iPatchRedirector.redirect((short) 10, this, i2);
            }
        }

        public void setIceBreakMsg(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 52)) {
                this.isIceBreakMsg = i2;
            } else {
                iPatchRedirector.redirect((short) 52, this, i2);
            }
        }

        public void setMagicFontType(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
                this.magicFontType = i2;
            } else {
                iPatchRedirector.redirect((short) 48, this, i2);
            }
        }

        public void setMsgBigClubFlag(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.msgBigClubFlag = i2;
            } else {
                iPatchRedirector.redirect((short) 6, this, i2);
            }
        }

        public void setMsgBigClubLevel(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.msgBigClubLevel = i2;
            } else {
                iPatchRedirector.redirect((short) 8, this, i2);
            }
        }

        public void setMsgVipLevel(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.msgVipLevel = i2;
            } else {
                iPatchRedirector.redirect((short) 4, this, i2);
            }
        }

        public void setMsgVipType(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.msgVipType = i2;
            } else {
                iPatchRedirector.redirect((short) 2, this, i2);
            }
        }

        public void setNamePlateId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                this.namePlateId = i2;
            } else {
                iPatchRedirector.redirect((short) 16, this, i2);
            }
        }

        public void setNamePlateType(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                this.namePlateType = i2;
            } else {
                iPatchRedirector.redirect((short) 12, this, i2);
            }
        }

        public void setPendantDiyInfoId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 38)) {
                this.pendantDiyInfoId = i2;
            } else {
                iPatchRedirector.redirect((short) 38, this, i2);
            }
        }

        public void setPendantId(long j2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
                this.pendantId = j2;
            } else {
                iPatchRedirector.redirect((short) 36, this, j2);
            }
        }

        public void setSubBubbleId(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
                this.subBubbleId = i2;
            } else {
                iPatchRedirector.redirect((short) 30, this, i2);
            }
        }

        public void setSubFontId(long j2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) {
                this.subFontId = j2;
            } else {
                iPatchRedirector.redirect((short) 42, this, j2);
            }
        }

        public void setTemplateID(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) {
                this.templateID = i2;
            } else {
                iPatchRedirector.redirect((short) 50, this, i2);
            }
        }

        public void setVipStarFlag(int i2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                this.vipStarFlag = i2;
            } else {
                iPatchRedirector.redirect((short) 14, this, i2);
            }
        }
    }


}
