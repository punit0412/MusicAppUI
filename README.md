# 🎵 MusicAppUI

A modern **Music Streaming UI** built using **Kotlin** and **Jetpack Compose** with intuitive navigation and a sleek design. This app demonstrates a multi-layered UI system including bottom navigation, drawer navigation, and modal bottom sheets.

---

## 📱 Features

- 🔻 **Bottom Navigation Bar** with:
  - **Home**
  - **Browse**
  - **Library**

- ⚡ **Top Action Button** that triggers a **Modal Bottom Sheet**

- 👤 **Navigation Drawer** (opened via profile icon) with:
  - **Add Account**
  - **Subscription**
  - **Account**

- 🔀 Each section (Bottom Navigation and Drawer items) opens a **dedicated screen**

- 💯 Built entirely using **Jetpack Compose**

---

## 🛠️ Built With

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern UI toolkit
- **Android Studio** - IDE
- **Material Design Components** - UI/UX

---

## 🚀 Getting Started

To run the app locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/MusicAppUI.git

2. Open in **Android Studio Arctic Fox or later**

**🧭 Navigation Overview**

***🔻 Bottom Navigation***
| Tab     | Description                   |
| ------- | ----------------------------- |
| Home    | Displays the home screen UI   |
| Browse  | Explore trending content      |
| Library | User's saved tracks/playlists |

**⬆️ Modal Bottom Sheet**

- Triggered by clicking the Action Button in the top bar

- Slides up from the bottom

- Can contain quick actions, filters, or shortcuts (customize as needed)

**📂 Navigation Drawer**

Opened by clicking the **Profile Icon** in the top app bar.
| Drawer Item  | Destination Screen         |
| ------------ | -------------------------- |
| Add Account  | Account creation/login     |
| Subscription | Subscription details/plans |
| Account      | Profile and account info   |

**📸 UI Preview**

**Account**


<img width="421" height="850" alt="image" src="https://github.com/user-attachments/assets/d2d5f9d3-a5cc-478e-a5c8-b93429cbcf81" />

**Side Drawer**


<img width="409" height="860" alt="image" src="https://github.com/user-attachments/assets/4d61bca2-e969-460c-a37a-76064571616e" />


**Add Account**


<img width="433" height="875" alt="image" src="https://github.com/user-attachments/assets/fa5e598a-3a23-4d2b-a3eb-7cab7ebae7cb" />

**Subscription**


<img width="438" height="859" alt="image" src="https://github.com/user-attachments/assets/d32efc44-6570-432d-8a92-6e78d2d60866" />

**Home**


<img width="426" height="855" alt="image" src="https://github.com/user-attachments/assets/f4323f57-682d-4d17-927f-4943bca2f2e1" />

**Browse**


<img width="433" height="865" alt="image" src="https://github.com/user-attachments/assets/91604302-b3b7-4d6d-9d7e-9400f29bd0ac" />

**Library**


<img width="410" height="858" alt="image" src="https://github.com/user-attachments/assets/a64474d5-9f43-4b00-9536-6e327acc0e46" />

**Action Item**


<img width="449" height="858" alt="image" src="https://github.com/user-attachments/assets/bcf7d6e1-37f1-4da1-b63c-e4b354741e57" />


**📂 Project Structure**

📁 MusicAppUI/

 ┣ 📁 ui/
 
 ┃ ┣ 📄 MainScreen.kt
 
 ┃ ┣ 📄 HomeScreen.kt
 
 ┃ ┣ 📄 BrowseScreen.kt
 
 ┃ ┣ 📄 LibraryScreen.kt
 
 ┃ ┣ 📄 DrawerContent.kt
 
 ┃ ┗ 📄 BottomSheetContent.kt
 
 ┣ 📁 navigation/
 
 ┃ ┗ 📄 NavGraph.kt
 
 ┣ 📁 viewmodel/
 
 ┃ ┗ 📄 MainViewModel.kt
 
 ┗ 📄 MainActivity.kt
 
















