/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ServicioDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.IPersonaDAO;
import ec.edu.ups.idao.IServicioDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Servicio;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.Menu_Principal;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class CreacionPDF {

    private IServicioDAO servicioDAO;
    private IPersonaDAO personaDAO;
    private IUsuarioDAO usuarioDAO;

    public CreacionPDF() {
        this.servicioDAO = new ServicioDAO();
        this.personaDAO = new PersonaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearFacturaPdf(Factura_Cabecera factura_Cabecera, List<Factura_Detalle> servicios,String txt) throws IOException {

        // Creación del archivo PDF
        String FACTURA_RUTA = "C:\\Facturas\\factura_" + servicios.get(0).getFac_id() +txt+ ".pdf";
        File file = new File(FACTURA_RUTA);
        file.getParentFile().mkdirs();

        // Creación del escritor PDF
        PdfWriter writer = new PdfWriter(FACTURA_RUTA);

        // Creación del documento PDF
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Fuente para el texto
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

        // Cabecera de la factura
        Paragraph empresa = new Paragraph("CLINICA VETERINARIA")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(font).setBold()
                .setFontSize(18f);
        document.add(empresa);

        Paragraph direccion = new Paragraph("Calle Vieja, Cuenca - Ecuador")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(font)
                .setFontSize(10f);
        document.add(direccion);

        Paragraph espacioParrafo = new Paragraph().setFixedLeading(25);
        document.add(espacioParrafo);

        LineSeparator separator = new LineSeparator(new SolidLine());
        document.add(separator);

        // Datos de la empresa
        Paragraph DatosEmpresa = new Paragraph("Datos de la Empresa:")
                .setTextAlignment(TextAlignment.LEFT)
                .setFont(font).setBold()
                .setFontSize(14f);
        document.add(DatosEmpresa);

        Text espacio = new Text("                    ");

        Text titulo1Txt = new Text("Usuario: ").setBold();
        Text usuarioTxt = new Text(Menu_Principal.instance.getArreglo()[0]);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(factura_Cabecera.getFecha().getTime());
        Text titulo2Txt = new Text("Fecha: ").setBold();
        Text fechaTxt = new Text("" + date);

        Text titulo3Txt = new Text("Factura #: ").setBold();
        Text facturaTxt = new Text("" + servicios.get(0).getFac_id());

        Paragraph cabecera = new Paragraph(titulo1Txt).add(usuarioTxt).add(espacio)
                .add(titulo2Txt).add(fechaTxt).add(espacio)
                .add(titulo3Txt).add(facturaTxt)
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(font);
        document.add(cabecera);
        
        
        document.add(espacioParrafo);
        document.add(separator);
        // Datos del cliente
        Paragraph DatoCliente = new Paragraph("Datos del Cliente:")
                .setTextAlignment(TextAlignment.LEFT)
                .setFont(font).setBold()
                .setFontSize(14f);
        document.add(DatoCliente);

        Persona clienteFactura = this.personaDAO.read(factura_Cabecera.getPer_id());

        Text titulo4Txt = new Text("Cedula: ").setBold();
        Text cedulaTxt = new Text(clienteFactura.getCedula());

        Text titulo5Txt = new Text("Nombre: ").setBold();
        Text nombreTxt = new Text(clienteFactura.getNombre());

        Text titulo6Txt = new Text("Apellido: ").setBold();
        Text apellidoTxt = new Text(clienteFactura.getApellido());

        Paragraph cliente1 = new Paragraph(titulo4Txt).add(cedulaTxt).add(espacio)
                .add(titulo5Txt).add(nombreTxt).add(espacio)
                .add(titulo6Txt).add(apellidoTxt)
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(font);
        document.add(cliente1);

        Text titulo7Txt = new Text("Dirección: ").setBold();
        Text direccionTxt = new Text(clienteFactura.getDireccion());

        Text titulo8Txt = new Text("Telefono: ").setBold();
        Text telefonoTxt = new Text(clienteFactura.getTelefono());

        Text titulo9Txt = new Text("Correo: ").setBold();
        Text correoTxt = new Text(clienteFactura.getCorreo());

        Paragraph cliente2 = new Paragraph(titulo7Txt).add(direccionTxt).add(espacio)
                .add(titulo8Txt).add(telefonoTxt).add(espacio)
                .add(titulo9Txt).add(correoTxt)
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(font);
        document.add(cliente2);

        document.add(separator);
        document.add(espacioParrafo);
        document.add(espacioParrafo);
        document.add(espacioParrafo);
        document.add(espacioParrafo);

        // Tabla de productos
        Table tabla = new Table(new float[]{2, 2, 2, 2, 2, 2, 2});
        tabla.setWidth(UnitValue.createPercentValue(100));

        Cell cellCabeceraCodigo = new Cell().add(new Paragraph("Codigo del servicio").setFont(font));
        Cell cellCabeceraNombre = new Cell().add(new Paragraph("Nombre del servicio").setFont(font));
        Cell cellCabeceraCantidad = new Cell().add(new Paragraph("Cantidad").setFont(font));
        Cell cellCabeceraPrecio = new Cell().add(new Paragraph("Precio").setFont(font));
        Cell cellCabeceraIva = new Cell().add(new Paragraph("Iva").setFont(font));
        Cell cellCabeceraSubTotal = new Cell().add(new Paragraph("SubTotal").setFont(font));
        Cell cellCabeceraTotal = new Cell().add(new Paragraph("Total").setFont(font));

        tabla.addHeaderCell(cellCabeceraCodigo);
        tabla.addHeaderCell(cellCabeceraNombre);
        tabla.addHeaderCell(cellCabeceraCantidad);
        tabla.addHeaderCell(cellCabeceraPrecio);
        tabla.addHeaderCell(cellCabeceraIva);
        tabla.addHeaderCell(cellCabeceraSubTotal);
        tabla.addHeaderCell(cellCabeceraTotal);

        for (Factura_Detalle facDet : servicios) {
            Cell cellCodigo = new Cell().add(new Paragraph("" + facDet.getSer_id()).setFont(font));
            Servicio ser = this.servicioDAO.read(facDet.getSer_id());
            Cell cellNombre = new Cell().add(new Paragraph("" + ser.getNombre()).setFont(font));
            Cell cellCantidad = new Cell().add(new Paragraph(String.valueOf("" + facDet.getCantidad())).setFont(font));
            Cell cellPrecio = new Cell().add(new Paragraph(String.valueOf("" + facDet.getPrecio_unitario())).setFont(font));
            Cell cellIva = new Cell().add(new Paragraph(String.valueOf("" + facDet.getValor_iva())).setFont(font));
            Cell cellSubTotal = new Cell().add(new Paragraph(String.valueOf("" + facDet.getSubtotal())).setFont(font));
            Cell cellTotal = new Cell().add(new Paragraph(String.valueOf("" + facDet.getTotal())).setFont(font));

            tabla.addCell(cellCodigo);
            tabla.addCell(cellNombre);
            tabla.addCell(cellCantidad);
            tabla.addCell(cellPrecio);
            tabla.addCell(cellIva);
            tabla.addCell(cellSubTotal);
            tabla.addCell(cellTotal);
        }

        document.add(tabla);

        // IVA, subtotal y total
        
        document.add(espacioParrafo);
        document.add(espacioParrafo);
        Text espacio2 = new Text("    ").setFont(font);

        Text titulo10Txt = new Text("IVA: ").setBold();
        Text ivaTxt = new Text("" + factura_Cabecera.getIva_total());

        Paragraph ivaParrafo = new Paragraph(titulo10Txt).add(espacio2).add(ivaTxt)
                .setTextAlignment(TextAlignment.RIGHT)
                .setFont(font)
                .setFontSize(14f);
        document.add(ivaParrafo);

        Text titulo11Txt = new Text("Subtotal: ").setBold();
        Text subtotalTxt = new Text("" + factura_Cabecera.getSubtotal());

        Paragraph subtotalParrafo = new Paragraph(titulo11Txt).add(espacio2).add(subtotalTxt)
                .setTextAlignment(TextAlignment.RIGHT)
                .setFont(font)
                .setFontSize(14f);
        document.add(subtotalParrafo);

        Text titulo12Txt = new Text("Total: ").setBold();
        Text totalTxt = new Text("" + factura_Cabecera.getTotal());

        Paragraph totalParrafo = new Paragraph(titulo12Txt).add(espacio2).add(totalTxt)
                .setTextAlignment(TextAlignment.RIGHT)
                .setFont(font)
                .setFontSize(16f);
        document.add(totalParrafo);
        
        if(factura_Cabecera.getEstado()=='N'){
            Image imagen = new Image(ImageDataFactory.create("src\\ec\\edu\\ups\\imagenes\\anulado.png"));
            document.add(imagen);
            
        }

        document.close();
        JOptionPane.showMessageDialog(null, "Factura en PDF creada");
        EnviarPdf ev=new EnviarPdf();
        String mensaje=clienteFactura.getNombre()+", mediante este correo Adjuntamos su Factura Electronica\n "
                + "gracias por confiar en nuestra clinica.";
        ev.enviar(clienteFactura.getCorreo(), mensaje, FACTURA_RUTA,"factura_" + servicios.get(0).getFac_id() +txt+ ".pdf" );
    }

}
