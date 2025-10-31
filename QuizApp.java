package Online_Quiz_App;

import java.io.*;
import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctAnswerIndex;

    Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = loadQuestionsFromCSV("questions.csv");
        if (questions.isEmpty()) {
            System.out.println("⚠️ No questions found! Please check your questions.csv file.");
            return;
        }

        // Randomize question order
        Collections.shuffle(questions);

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("=== 🧠 Welcome to the Java Quiz App! ===\n");

        int qNum = 1;
        for (Question q : questions) {
            System.out.println("Q" + qNum + ": " + q.questionText);

            // Shuffle options while keeping track of correct answer
            List<Integer> indices = Arrays.asList(0, 1, 2, 3);
            Collections.shuffle(indices);

            int correctOption = -1;
            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ") " + q.options.get(indices.get(i)));
                if (indices.get(i) == q.correctAnswerIndex - 1) {
                    correctOption = i + 1;
                }
            }

            int ans = -1;
            while (true) {
                System.out.print("Enter your answer (1-4): ");
                try {
                    ans = sc.nextInt();
                    if (ans >= 1 && ans <= 4) break;
                    else System.out.println("⚠️ Please enter a number between 1 and 4.");
                } catch (InputMismatchException e) {
                    System.out.println("⚠️ Invalid input! Please enter a number.");
                    sc.next(); // clear invalid input
                }
            }

            if (ans == correctOption) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer was: " +
                        q.options.get(q.correctAnswerIndex - 1) + "\n");
            }

            qNum++;
        }

        System.out.println("🎯 Quiz Finished!");
        System.out.println("Your Score: " + score + " / " + questions.size());
        double percent = ((double) score / questions.size()) * 100;
        System.out.printf("Percentage: %.2f%%\n", percent);

        if (percent >= 70)
            System.out.println("🏆 Excellent!");
        else if (percent >= 50)
            System.out.println("👍 Good effort!");
        else
            System.out.println("📚 Keep practicing!");

        sc.close();
    }

    public static List<Question> loadQuestionsFromCSV(String filename) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length < 6) {
                    System.out.println("⚠️ Skipping invalid line: " + line);
                    continue;
                }

                String question = parts[0].trim();
                List<String> options = Arrays.asList(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim());
                int correct = Integer.parseInt(parts[5].trim());

                questions.add(new Question(question, options, correct));
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error loading questions: " + e.getMessage());
        }

        return questions;
    }
}
