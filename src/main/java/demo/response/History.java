package demo.response;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idtransaksi",
        "namaUser",
        "nomorTeleponUser",
        "nomorPaketData",
        "namaProvider",
        "paketData",
        "harga",
        "tanggal",
        "pembayaranMelalui",
        "statusPembayaran",
        "saldoAkhir",
        "statusUpload",
        "status",
        "message"
})
public class History {

    @JsonProperty("idtransaksi")
    private Long idtransaksi;
    @JsonProperty("namaUser")
    private String namaUser;
    @JsonProperty("nomorTeleponUser")
    private String nomorTeleponUser;
    @JsonProperty("nomorPaketData")
    private String nomorPaketData;
    @JsonProperty("namaProvider")
    private String namaProvider;
    @JsonProperty("paketData")
    private String paketData;
    @JsonProperty("harga")
    private Long harga;
    @JsonProperty("tanggal")
    private String tanggal;
    @JsonProperty("pembayaranMelalui")
    private String pembayaranMelalui;
    @JsonProperty("statusPembayaran")
    private Boolean statusPembayaran;
    @JsonProperty("saldoAkhir")
    private Long saldoAkhir;
    @JsonProperty("statusUpload")
    private Boolean statusUpload;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idtransaksi")
    public Long getIdtransaksi() {
        return idtransaksi;
    }

    @JsonProperty("idtransaksi")
    public void setIdtransaksi(Long idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    @JsonProperty("namaUser")
    public String getNamaUser() {
        return namaUser;
    }

    @JsonProperty("namaUser")
    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    @JsonProperty("nomorTeleponUser")
    public String getNomorTeleponUser() {
        return nomorTeleponUser;
    }

    @JsonProperty("nomorTeleponUser")
    public void setNomorTeleponUser(String nomorTeleponUser) {
        this.nomorTeleponUser = nomorTeleponUser;
    }

    @JsonProperty("nomorPaketData")
    public String getNomorPaketData() {
        return nomorPaketData;
    }

    @JsonProperty("nomorPaketData")
    public void setNomorPaketData(String nomorPaketData) {
        this.nomorPaketData = nomorPaketData;
    }

    @JsonProperty("namaProvider")
    public String getNamaProvider() {
        return namaProvider;
    }

    @JsonProperty("namaProvider")
    public void setNamaProvider(String namaProvider) {
        this.namaProvider = namaProvider;
    }

    @JsonProperty("paketData")
    public String getPaketData() {
        return paketData;
    }

    @JsonProperty("paketData")
    public void setPaketData(String paketData) {
        this.paketData = paketData;
    }

    @JsonProperty("harga")
    public Long getHarga() {
        return harga;
    }

    @JsonProperty("harga")
    public void setHarga(Long harga) {
        this.harga = harga;
    }

    @JsonProperty("tanggal")
    public String getTanggal() {
        return tanggal;
    }

    @JsonProperty("tanggal")
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @JsonProperty("pembayaranMelalui")
    public String getPembayaranMelalui() {
        return pembayaranMelalui;
    }

    @JsonProperty("pembayaranMelalui")
    public void setPembayaranMelalui(String pembayaranMelalui) {
        this.pembayaranMelalui = pembayaranMelalui;
    }

    @JsonProperty("statusPembayaran")
    public Boolean getStatusPembayaran() {
        return statusPembayaran;
    }

    @JsonProperty("statusPembayaran")
    public void setStatusPembayaran(Boolean statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    @JsonProperty("saldoAkhir")
    public Long getSaldoAkhir() {
        return saldoAkhir;
    }

    @JsonProperty("saldoAkhir")
    public void setSaldoAkhir(Long saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    @JsonProperty("statusUpload")
    public Boolean getStatusUpload() {
        return statusUpload;
    }

    @JsonProperty("statusUpload")
    public void setStatusUpload(Boolean statusUpload) {
        this.statusUpload = statusUpload;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}