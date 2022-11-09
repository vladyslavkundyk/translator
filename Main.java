package translator;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Vocabulary dictionary = new Vocabulary();

		String fileName = "Text";
		File fileWithText = new File("D:\\Словник\\" + fileName + ".in");

		// Додаю англійські слова до словника
		dictionary.addWordToDictionary("I", "Я");
		dictionary.addWordToDictionary("get", "отримую");
		dictionary.addWordToDictionary("good", "гарні");
		dictionary.addWordToDictionary("grades", "оцінки");
		dictionary.addWordToDictionary("in", "у");
		dictionary.addWordToDictionary("school", "школі");

		// Додаю іспанські слова до словника
		dictionary.addWordToDictionary("Yo", "Я");
		dictionary.addWordToDictionary("saco", "отримую");
		dictionary.addWordToDictionary("buenas", "гарні");
		dictionary.addWordToDictionary("notas", "оцінки");
		dictionary.addWordToDictionary("en", "у");
		dictionary.addWordToDictionary("escuela", "школі");

		// Можу перекласти або з англійскої або з іспанської
		System.out.println("Переклад із файлу " + fileName + ": \n" + dictionary.translateTextFromFile(fileWithText));
		dictionary.translateTextToFile(new File("D:\\Словник\\Ukrainian.out"));
	}
}
