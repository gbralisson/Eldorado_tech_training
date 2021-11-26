
TARGET_ARCH := arm64
TARGET_ARCH_VARIANT := armv8-a
TARGET_CPU_ABI := arm64-v8a
TARGET_CPU_ABI2 :=
TARGET_CPU_VARIANT := generic
TARGET_CPU_VARIANT_RUNTIME := cortex-a76

BOARD_KERNEL_CMDLINE += console=ttyMSM0,115200n8 androidboot.console=ttyMSM0 printk.devkmsg=on

# product.img
BOARD_PRODUCTIMAGE_FILE_SYSTEM_TYPE := ext4

# system_ext.img
BOARD_SYSTEM_EXTIMAGE_FILE_SYSTEM_TYPE := ext4

# userdata.img
TARGET_USERIMAGES_USE_F2FS := true

BOARD_HAVE_BLUETOOTH_QCOM := true

# GPS
TARGET_USES_HARDWARE_QCOM_GPS := false

# Sensors
USE_SENSOR_MULTI_HAL := true

# wlan
BOARD_WLAN_DEVICE := qcwcn
BOARD_WPA_SUPPLICANT_DRIVER := NL80211

TARGET_SCREEN_DENSITY := 440