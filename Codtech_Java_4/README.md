# Task 4: AI-Based Recommendation System

## 🤖 Project Overview
This project implements a **User-Based Collaborative Filtering** engine using the Apache Mahout machine learning framework[cite: 1]. The system analyzes user behavior patterns and item ratings to predict and recommend new content that a user is likely to enjoy based on the preferences of mathematically similar "neighbors"[cite: 1].

## 🚀 Key Features
* **Collaborative Filtering**: Moves beyond simple keyword matching to find patterns in community behavior[cite: 1].
* **Pearson Correlation Similarity**: Employs advanced statistical methods to calculate the relationship between different users' tastes[cite: 1].
* **Nearest Neighbor Analysis**: Utilizes `NearestNUserNeighborhood` to identify the most relevant group of peers for any given user[cite: 1].
* **Confidence Scoring**: Not only recommends items but also provides a "Confidence Score" indicating the predicted strength of the user's preference[cite: 1].

## 🛠️ Technical Stack & Dependencies
This project requires several Java libraries (JARs) to handle the complex machine learning mathematics[cite: 1]:
* **Apache Mahout (MR & Math)**: The core recommendation engine[cite: 1].
* **Google Guava**: For internal collection management and preconditions[cite: 1].
* **Apache Commons Math**: For low-level numerical computing and hashing[cite: 1].
* **SLF4J**: For logging internal engine processes[cite: 1].

## 📂 Data Structure (`data.csv`)
The engine processes a CSV file with the following format: `UserID, ItemID, Rating`[cite: 1].
> **Example**: `1, 101, 5.0` (User 1 gave Item 101 a 5-star rating)[cite: 1].

## 📖 How to Run
1. Ensure all required JAR files are placed in the `Codtech_Java_4/lib/` folder[cite: 1].
2. Add the JARs to your **Referenced Libraries** in VS Code[cite: 1].
3. Compile the project from the root directory:
   ```powershell
   javac -cp "Codtech_Java_4/lib/*" Codtech_Java_4/RecommendationSystem.java
4. Execute the AI engine:
   ```powershell
    java -cp ".;Codtech_Java_4/lib/*" Codtech_Java_4.RecommendationSystem
## 📊 Sample Output
```text
============================================
   🎯 CODTECH AI RECOMMENDATION ENGINE 🎯   
============================================

✨ Recommended Item ID: 106 (Confidence Score: 5.00)

============================================