package translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary {

	private Map<String, String> dictionary = new HashMap<String, String>();
	private String translatedText;

	public Vocabulary(Map<String, String> dictionary, String translatedText) {
		super();
		this.dictionary = dictionary;
		this.translatedText = translatedText;
	}

	public Vocabulary() {
		super();
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	private String loadTextFromFile(File eng) {

		String tempText = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(eng))) {
			String readed;
			while ((readed = br.readLine()) != null) {
				tempText += readed + System.lineSeparator();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempText;
	}

	public void addWordToDictionary(String languageWord, String ukrainianWord) {
		dictionary.put(languageWord, ukrainianWord);
	}

	public String translateTextFromFile(File textToTranslateFile) {

		String tempWord = "";
		String tempLanguageText = this.loadTextFromFile(textToTranslateFile);
		String resultUkrainianText = "";
		char textSymb;

		for (int i = 0; i < tempLanguageText.length(); i++) {
			textSymb = tempLanguageText.charAt(i);
			if (Character.isLetter(textSymb)) {
				tempWord += textSymb;
			} else if (tempWord.compareTo("") != 0) {
				resultUkrainianText += dictionary.get(tempWord);
				resultUkrainianText += textSymb;
				tempWord = "";
			} else {
				resultUkrainianText += textSymb;
			}
		}
		translatedText = resultUkrainianText;
		return translatedText;
	}

	public void translateTextToFile(File ukrainianFile) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ukrainianFile))) {
			bw.write(translatedText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Vocabulary [dictionary=" + dictionary + ", translatedText=" + translatedText + "]";
	}
}
