$(call inherit-product, $(SRC_TARGET_DIR)/product/aosp_x86_64.mk)

PRODUCT_NAME := josericardo
PRODUCT_DEVICE := josericardo
PRODUCT_BRAND := Android
PRODUCT_MODEL := AOSP josericardo Emulator

PRODUCT_PACKAGES += \
LiveWallpapers	\
Gallery2	\
SoundRecorder	\
Camera	\
Email	\
FSLOta	\
CactusPlayer	\
VideoEditor	\
FSLProfileApp \
FSLProfileService \
PinyinIME

PRODUCT_COPY_FILES += \
device/EldoradoTech/josericardo/init.rc:root/init.ranchu.rc	\
device/EldoradoTech/josericardo/vold.fstab:system/etc/vold.fstab	\
$(LOCAL_PATH)/gpsreset.sh:$(TARGET_COPY_OUT_SYSTEM)/etc/gpsreset.sh
