package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface PdfExportService  {

    public void make(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
