package com.pushtorefresh.storio.common.annotations.processor.introspection;

import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;

import javax.lang.model.element.Element;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class StorIOColumnMetaTest {

	private Annotation annotationMock;
	private Element elementMock;
	private JavaType javaType;

	@Before
	public void setUp() throws Exception {
		annotationMock = mock(Annotation.class);
		elementMock = mock(Element.class);
		javaType = JavaType.BOOLEAN;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void constructor() {
		// when
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "TEST", javaType,
				annotationMock);

		// then
		assertThat(elementMock).as("Constructor must be set enclosingElement field.")
				.isEqualTo(storioColumnMeta.enclosingElement);
		assertThat(elementMock).as("Constructor must be set element field.")
				.isEqualTo(storioColumnMeta.element);
		assertThat("TEST").as("Constructor must be set elementName field.")
				.isEqualTo(storioColumnMeta.elementName);
		assertThat(javaType).as("Constructor must be set javaType field.")
				.isEqualTo(storioColumnMeta.javaType);
		assertThat(annotationMock).as("Constructor must be set storIOColumn field.")
				.isEqualTo(storioColumnMeta.storIOColumn);
	}

	@Test
	public final void equalsAndHashCode() {
		EqualsVerifier.forClass(StorIOColumnMeta.class).suppress(Warning.REFERENCE_EQUALITY).usingGetClass().verify();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void toStringValidation() {
		// given
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "TEST", javaType,
				annotationMock);
		String expectedString = "StorIOColumnMeta{enclosingElement=" + elementMock + ", element=" + elementMock
				+ ", elementName='TEST" + '\'' + ", javaType=" + javaType + ", storIOColumn=" + annotationMock +  '}';

		// when
		String toString = storioColumnMeta.toString();

		// then
		assertThat(expectedString).as("toString method should be equal with expectedString.").isEqualTo(toString);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementWithoutPrefixes() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "property", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("property");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementWithGetPrefix() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "getProperty", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("property");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementWithIsPrefix() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "isProperty", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("property");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementWithOneCharacterName() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "a", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("a");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementStartsWithGet() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "getter", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("getter");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void shouldReturnRealElementNameForElementStartsWithIs() {
		StorIOColumnMeta storioColumnMeta = new StorIOColumnMeta(elementMock, elementMock, "iso", javaType,
				annotationMock);

		String realName = storioColumnMeta.getRealElementName();

		assertThat(realName).isEqualTo("iso");
	}

}
