

$(call inherit-product, $(SRC_TARGET_DIR)/product/aosp_x86_64.mk)

PRODUCT_NAME := jonasmoreira
PRODUCT_DEVICE := jonasmoreira
PRODUCT_BRAND := Android
PRODUCT_MODEL := AOSP

PRODUCT_PACKAGES +=	\
  LiveWallpapers	\
  Gallery2		\
  SoundRecorder		\
  Camera		\
  Email			\
  FSLOta		\
  CactusPlayer		\
  VideoEditor		\
  FSLProfileApp		\
  FSLProfileService	\
  PinyinIME

PRODUCT_COPY_FILES += \
  device/EldoradoTech/jonasmoreira/init.tc:root/init.ranchu.tc		\
  device/EldoradoTech/jonasmoreira/vold.fstab:system/etc/vold.fstab	\
  $(LOCAL_PATH)/gpsreset.sh:$(TARGET_COPY_OUT_SYSTEM)/etc/gpsreset.sh
