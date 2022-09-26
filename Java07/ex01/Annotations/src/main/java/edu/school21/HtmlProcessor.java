package edu.school21;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes({"edu.school21.HtmlForm", "edu.school21.HtmlInput"})
public class HtmlProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element userForm : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
			HtmlForm htmlForm = userForm.getAnnotation(HtmlForm.class);
			String line = "<form action = \"" + htmlForm.action() + "\" method = \"" + htmlForm.method() + "\">\n";
			List<? extends Element> userFormElements = userForm.getEnclosedElements();
			for (Element field : roundEnv.getElementsAnnotatedWith(HtmlInput.class)) {
				if (!userFormElements.contains(field)) {
					continue;
				}
				HtmlInput htmlInput = field.getAnnotation(HtmlInput.class);
				line += "\t<input type = "
						+ htmlInput.type() + "\" name = \""
						+ htmlInput.name() + "\" placeholder = \""
						+ htmlInput.placeholder() + "\">\n";
			}
			line += "\t<input type=\"submit\" value = \"Send\">\n</form>";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("target/classes/" + htmlForm.fileName()))) {
				writer.write(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
