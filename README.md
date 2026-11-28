# Home Assistant Companion for Android（国内定位增强版）

[![Sync & Build APK](https://github.com/Yunlliang/homeassistant-cn/actions/workflows/build-apk.yml/badge.svg)](https://github.com/Yunlliang/homeassistant-cn/actions/workflows/build-apk.yml)
[![Latest Release](https://img.shields.io/github/v/release/Yunlliang/homeassistant-cn?label=Release&logo=homeassistant)](https://github.com/Yunlliang/homeassistant-cn/releases)
[![Upstream](https://img.shields.io/badge/Upstream-home--assistant%2Fandroid-41BDF5?logo=github)](https://github.com/home-assistant/android)

基于官方 [home-assistant/android](https://github.com/home-assistant/android) 构建的**中国大陆定位增强正式版**，专为无 Google Play 服务（GMS）或国内网络环境下的安卓手机优化。

## 主要特性

- **高德定位 + 原生 GPS 双重回退**：在保留官方定位逻辑的基础上，接入**高德定位 SDK（AMap Location）**与 **Android 原生 GPS / 网络定位**，小米、华为、荣耀、OPPO、vivo 等国产机型无需 GMS 或代理即可稳定上报后台定位与单次高精度定位。
- **坐标系自动纠偏（GCJ-02 → WGS-84）**：自动将高德返回的国内火星坐标（`GCJ-02`）转换为 Home Assistant 标准地球坐标（`WGS-84`），解决回家/离家区域判断偏移问题。
- **单一正式版安装包**：使用 `fullRelease` 正式模式与固定密钥签名打包，包名为标准 `io.homeassistant.companion.android`，桌面仅显示 **1 个**应用图标，不包含任何调试插件或闪退组件。
- **版本号与官方同步**：同步官方全部版本标签（如 `2026.11.2-full`）及官方同款递增 `versionCode`，后续可直接覆盖安装升级。
- **每日自动同步官方更新**：GitHub Actions 每天**北京时间 04:00** 自动检查并合并官方 `home-assistant/android` 最新 `main` 分支代码与版本标签，有更新时自动编译新 APK 并发布到 [Releases](https://github.com/Yunlliang/homeassistant-cn/releases)；也可随时在 [Actions](https://github.com/Yunlliang/homeassistant-cn/actions/workflows/build-apk.yml) 手动点击 **Run workflow** 立即同步打包。

## 下载与安装

1. 前往 [**Releases 页面**](https://github.com/Yunlliang/homeassistant-cn/releases) 下载最新版本的 `home-assistant-cn-<版本号>-full-release.apk`（若首次构建尚在进行中，请等待 [Actions 构建任务](https://github.com/Yunlliang/homeassistant-cn/actions/workflows/build-apk.yml) 完成后刷新 Releases 页面）。
2. **首次安装提示**：如果手机上之前安装过 Play 商店版、GitHub 官方原版或旧的 Debug 测试包，因签名不同请**先卸载旧版本**再安装本包；之后本仓库发布的后续新版本均可**直接覆盖升级**，无需卸载。
3. **后台定位权限建议**：安装打开并连接你的 Home Assistant 服务器后，请在「设置 → 伴侣应用 → 传感器 → 位置传感器」中开启后台定位，并在手机系统中授予「**始终允许**」位置权限及「**无限制 / 允许后台活动**」电池策略。

## 仓库密钥说明（自建编译参考）

本仓库通过 [`.github/workflows/build-apk.yml`](.github/workflows/build-apk.yml) 自动签名打包，依赖以下 GitHub Actions Secrets：

| Secret 名称 | 说明 |
| --- | --- |
| `AMAP_API_KEY` | 高德开放平台 Android 平台定位 Key（绑定包名 `io.homeassistant.companion.android` 与签名证书 `SHA1`） |
| `ANDROID_KEYSTORE_BASE64` | PKCS12 签名证书（别名 `ha-cn`）经 Base64 编码后的内容 |
| `ANDROID_KEYSTORE_PASSWORD` | 签名证书密码 |

---

# Home Assistant Companion for Android (Upstream README)

[![Build Status](https://github.com/home-assistant/android/actions/workflows/onPush.yml/badge.svg)](https://github.com/home-assistant/android/actions/workflows/onPush.yml)
[![E2E Status](https://github.com/home-assistant/android/actions/workflows/e2e.yml/badge.svg)](https://github.com/home-assistant/android/actions/workflows/e2e.yml)
[![Play Store](https://img.shields.io/badge/Play%20Store-Download-blue?logo=google-play)](https://play.google.com/store/apps/details?id=io.homeassistant.companion.android)
[![Play Store Beta](https://img.shields.io/badge/Play%20Store%20Beta-Download-blue?logo=google-play)](https://play.google.com/apps/testing/io.homeassistant.companion.android)
[![Discord](https://img.shields.io/discord/330944238910963714?label=Discord&logo=discord)](https://discord.gg/c5DvZ4e)
[![Stars](https://img.shields.io/github/stars/home-assistant/android?style=social)](https://github.com/home-assistant/android/stargazers)

Welcome to the **Home Assistant Companion for Android**! This is the official Android app for [Home Assistant](https://www.home-assistant.io/), a powerful open-source home automation platform. Join us in building an app used by millions of users worldwide.

---

## Features

- **Control Your Smart Home**: Seamlessly interact with your Home Assistant instance.
- **Native Android Experience**: Leverage Android-specific features like widgets, notifications, and location tracking.
- **Customizable**: Tailor the app to your needs with themes, dashboards, and more.
- **Open Source**: Contribute to a project that empowers users to take control of their smart homes.

## Get the app

- **[Download from the Play Store](https://play.google.com/store/apps/details?id=io.homeassistant.companion.android)**
  Join the [Play Store Beta](https://play.google.com/apps/testing/io.homeassistant.companion.android) to test new features early.
- **Other Stores**: The app is also available in other app stores.

## Documentation

Looking for help? Check out the [Home Assistant Companion Documentation](https://companion.home-assistant.io/) for detailed guides on using the app.

## Report a bug or request a feature

Found a bug or have an idea for a new feature? Let us know!

- **[Open a Bug Report](https://github.com/home-assistant/android/issues/new?template=bug_report.yml)**
- **[Request a Feature](https://github.com/home-assistant/android/issues/new?template=feature_request.md)**

We appreciate your feedback and contributions to make the app even better!

## Contributing

We are thrilled to welcome contributions from the community! This app exists thanks to the incredible efforts of the Home Assistant community. Whether you're fixing bugs, adding new features, or improving documentation, your contributions make a difference.

Every contribution, big or small, is greatly appreciated. Together, we can make the Home Assistant Companion for Android even better!

### Getting started

1. Read the [Developer Guide](https://contributors.home-assistant.io/companion/android/).
2. Fork the repository and create a branch for your changes.
3. Submit a pull request and join the discussion!

## Join the community

Connect with other contributors and users in our vibrant **[Discord Community](https://discord.gg/c5DvZ4e)**: Join the **[#Android](https://discord.com/channels/330944238910963714/1346948551892009101)** channel to chat with developers and contributors.

## Star the repository

If you find this project useful, consider giving it a star on GitHub!
It helps others discover the project and motivates us to keep improving.

[![Home Assistant - A project from the Open Home Foundation](https://www.openhomefoundation.org/badges/home-assistant.png)](https://www.openhomefoundation.org/)
