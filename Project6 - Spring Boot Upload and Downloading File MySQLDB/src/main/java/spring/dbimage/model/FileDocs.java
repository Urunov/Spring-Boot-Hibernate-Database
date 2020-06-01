package spring.dbimage.model;

import javax.persistence.*;

/**
 * @Created 01 / 06 / 2020 - 1:48 PM
 * @project SpringDBImage
 * @Author Hamdamboy
 */
@Entity
@Table(name="filedocs")
public class FileDocs {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String docName;
    private String docType;

    @Lob
    private byte [] data;

    public FileDocs(String docName, String docType, byte[] data){
        super();
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public FileDocs(){}



}
