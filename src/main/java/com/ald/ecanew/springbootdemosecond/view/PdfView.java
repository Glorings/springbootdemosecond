package com.ald.ecanew.springbootdemosecond.view;

import com.ald.ecanew.springbootdemosecond.biz.PdfExportService;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class PdfView extends AbstractPdfView {

    PdfExportService pdfExportService = null;

  /*  public PdfView(PdfExportService pdfExportService){
        this.pdfExportService=pdfExportService;
    }*/

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

    }
}