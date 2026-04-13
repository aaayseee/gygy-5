# HTTP İsteğinin Anatomisi

HTTP (HyperText Transfer Protocol), istemci ile sunucu arasındaki veri alışverişini yöneten protokoldür. Her HTTP isteği belirli bir yapıya sahiptir.

---

## Genel Yapı

Bir HTTP isteği dört ana bölümden oluşur:

```
[İstek Satırı]
[Başlıklar (Headers)]
[Boş Satır]
[Gövde (Body) — opsiyonel]
```

---

## 1. İstek Satırı (Request Line)

İsteğin ilk satırıdır ve üç parçadan oluşur:

```
GET /api/users HTTP/1.1
```

| Parça | Örnek | Açıklama |
|---|---|---|
| **Metot** | `GET` | Yapılacak işlemi belirtir |
| **Yol (Path)** | `/api/users` | Hedef kaynağın adresi |
| **HTTP Versiyonu** | `HTTP/1.1` | Kullanılan protokol versiyonu |

### HTTP Metotları

| Metot | Kullanım Amacı | Gövde? | Idempotent? |
|---|---|---|---|
| `GET` | Veri okuma | ❌ | ✅ |
| `POST` | Yeni kaynak oluşturma | ✅ | ❌ |
| `PUT` | Kaynağı tamamen güncelleme | ✅ | ✅ |
| `PATCH` | Kaynağı kısmen güncelleme | ✅ | ❌ |
| `DELETE` | Kaynağı silme | ❌ | ✅ |
| `HEAD` | Sadece başlıkları alma | ❌ | ✅ |
| `OPTIONS` | Desteklenen metotları sorgulama | ❌ | ✅ |

---

## 2. Başlıklar (Headers)

Başlıklar, istek hakkında meta bilgi taşır. `Anahtar: Değer` formatındadır.

```http
Host: api.example.com
Accept: application/json
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)
Content-Length: 87
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
```

### Yaygın Başlıklar

| Başlık | Açıklama | Örnek |
|---|---|---|
| `Host` | Hedef sunucunun adresi **(zorunlu)** | `api.example.com` |
| `Content-Type` | Gövdenin veri formatı | `application/json` |
| `Accept` | İstemcinin kabul ettiği format | `application/json` |
| `Authorization` | Kimlik doğrulama bilgisi | `Bearer <token>` |
| `User-Agent` | İsteği yapan uygulama | `Mozilla/5.0 ...` |
| `Content-Length` | Gövdenin byte cinsinden boyutu | `87` |
| `Cookie` | Sunucudan önceden gelen çerezler | `session_id=abc123` |
| `Cache-Control` | Önbellekleme direktifleri | `no-cache` |
| `Accept-Language` | Tercih edilen dil | `tr-TR, en;q=0.9` |

---

## 3. Boş Satır

Başlıklar ile gövde arasında **mutlaka** bir boş satır bulunur. Bu satır, sunucuya başlıkların bittiğini ve gövdenin (varsa) başladığını bildirir.

---

## 4. Gövde (Request Body)

Sunucuya gönderilecek veriyi içerir. Her metotta bulunmaz; genellikle `POST`, `PUT` ve `PATCH` isteklerinde kullanılır.

### JSON Gövdesi

```json
{
  "username": "ahmet_yilmaz",
  "email": "ahmet@example.com",
  "password": "Gizli@123"
}
```

### Form Verisi (URL Encoded)

```
username=ahmet_yilmaz&email=ahmet%40example.com
```

### Multipart Form (Dosya Yükleme)

```
--boundary123
Content-Disposition: form-data; name="file"; filename="photo.jpg"
Content-Type: image/jpeg

[ikili dosya verisi...]
--boundary123--
```

---

## Tam Örnek: POST İsteği

```http
POST /api/users HTTP/1.1
Host: api.example.com
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
Accept: application/json
User-Agent: MyApp/2.0
Content-Length: 87
Connection: keep-alive

{
  "username": "ahmet_yilmaz",
  "email": "ahmet@example.com",
  "password": "Gizli@123"
}
```

---

## Tam Örnek: GET İsteği

```http
GET /api/users/42?include=profile HTTP/1.1
Host: api.example.com
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
Accept: application/json
User-Agent: MyApp/2.0
Connection: keep-alive
```

> **Not:** GET isteklerinde gövde bulunmaz. Ek parametreler URL üzerinden `?key=value` formatında gönderilir.

---

## URL'nin Anatomisi

Bir HTTP isteğindeki URL de kendi içinde birkaç parçaya ayrılır:

```
https://api.example.com:443/api/users/42?sort=asc&limit=10#results
  │         │              │      │       │                  │
  │         │              │      │       │                  └─ Fragment (Parça)
  │         │              │      │       └─ Query String (Sorgu Parametreleri)
  │         │              │      └─ Path (Yol)
  │         │              └─ Port
  │         └─ Host (Alan Adı)
  └─ Scheme (Protokol)
```

---

## HTTP Versiyonları

| Versiyon | Özellikler |
|---|---|
| **HTTP/1.0** | Her istek için yeni bağlantı açar |
| **HTTP/1.1** | Kalıcı bağlantı (`keep-alive`), pipeline desteği |
| **HTTP/2** | Multiplexing, header sıkıştırma, sunucu push |
| **HTTP/3** | QUIC protokolü üzerinde çalışır, daha hızlı bağlantı |

---

## İstek-Yanıt Döngüsü

```
İstemci                              Sunucu
   │                                    │
   │──── TCP Bağlantısı Kur ───────────>│
   │                                    │
   │──── HTTP İsteği Gönder ───────────>│
   │     POST /api/users HTTP/1.1       │
   │     Host: api.example.com          │
   │     Content-Type: application/json │
   │     { "username": "ahmet" }        │
   │                                    │
   │<─── HTTP Yanıtı Al ────────────────│
   │     HTTP/1.1 201 Created           │
   │     Content-Type: application/json │
   │     { "id": 42, "username": ... }  │
   │                                    │
```

---

## Özet

```
┌─────────────────────────────────────────────────┐
│                  HTTP İSTEĞİ                    │
├─────────────────────────────────────────────────┤
│  İSTEK SATIRI  │  POST /api/users HTTP/1.1      │
├─────────────────────────────────────────────────┤
│               │  Host: api.example.com           │
│  BAŞLIKLAR    │  Content-Type: application/json  │
│  (Headers)    │  Authorization: Bearer <token>   │
│               │  Content-Length: 87              │
├─────────────────────────────────────────────────┤
│  BOŞ SATIR    │  (CRLF)                          │
├─────────────────────────────────────────────────┤
│               │  {                               │
│  GÖVDE        │    "username": "ahmet_yilmaz",   │
│  (Body)       │    "email": "ahmet@example.com"  │
│               │  }                               │
└─────────────────────────────────────────────────┘
```
