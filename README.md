# 🚨 Disaster Radar (Disaster App) - Frontend MVP

An Android-based prototype aimed at filtering information pollution (misinformation) on social media during disasters and emergencies, presenting verified and critical alerts to users through a clean and structured interface.

This project is a Frontend MVP (Minimum Viable Product) developed to demonstrate how complex, high-volume crisis data can be rendered in a hierarchical and highly readable format.

## ✨ Key Features

* **Dynamic Color Hierarchy:** The title color changes dynamically based on the alert's urgency level (Critical -> Red, Warning -> Orange, Information -> Blue, Help -> Green). This approach is designed to effectively manage user panic levels.
* **Expandable UI Architecture:** To prevent cognitive overload and screen clutter, detailed descriptions and action buttons are hidden by default and expand smoothly only when a card is clicked.
* **Resolve (Dismissal) Mechanism:** Verified or resolved alerts can be dynamically dismissed from the feed using the "Kaldır" (Remove) button, leveraging `notifyItemRemoved` for smooth native removal animations.
* **Clean Code & OOP Standards:** Built with a strict separation of concerns among the data model (`Alert`), the adapter (`AlertAdapter`), and the views, adhering to object-oriented programming best practices.

## 🛠️ Tech Stack & Components

* **Language:** Java
* **Platform:** Android Studio
* **Core UI Components:** RecyclerView, MaterialCardView, ConstraintLayout, FloatingActionButton
* **Design Practices:** Material Design guidelines, Open Sans typography for enhanced readability, and strict Light-Mode stabilization.

## 🚀 Future Roadmap (Phase 2)

While this MVP operates with static data (Mock Data) optimized for frontend prototyping, the next development phases will include:
1.  **Form Integration:** Implementing a structured user-input form triggered by the Floating Action Button (FAB) to submit new alerts.
2.  **Backend Integration:** Connecting the application to a live database/server (e.g., Firebase or a custom API) for real-time synchronization.
3.  **Location Services:** Integrating Google Maps API to filter alerts dynamically based on the user's live geolocation.

---
*Note: This repository represents a frontend architecture and data visualization prototype for crisis management.*
