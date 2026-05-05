package Codtech_Java_4;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import java.io.File;
import java.util.List;

public class RecommendationSystem {
    public static void main(String[] args) {
        try {
            // Load dataset
            File dataFile = new File("Codtech_Java_4/data.csv");
            DataModel model = new FileDataModel(dataFile);

            // Calculate how similar users are (Pearson Correlation)
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Instead of a threshold, let's find the 2 most similar users (Nearest Neighbors)
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Generate top 3 recommendations for User 1
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);

            System.out.println("\n============================================");
            System.out.println("   🎯 CODTECH AI RECOMMENDATION ENGINE 🎯   ");
            System.out.println("============================================\n");
            
            if (recommendations.isEmpty()) {
                System.out.println("ℹ️ No strong patterns found for User 1 yet.");
            } else {
                for (RecommendedItem recommendation : recommendations) {
                    System.out.printf("✨ Recommended Item ID: %d (Confidence Score: %.2f)\n", 
                                      recommendation.getItemID(), recommendation.getValue());
                }
            }
            System.out.println("\n============================================");

        } catch (Exception e) {
            System.err.println("⚠️ Engine Error: " + e.getMessage());
        }
    }
}