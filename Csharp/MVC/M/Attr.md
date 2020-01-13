using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;



public DbSet<TableName> TableName { get; set; }

[Table("TableName")]

[DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]

[Key]

[Key, Column(Order = 0)]

public ICollection<System.Web.Mvc.SelectListItem> SelectList { get; set; }

[Required]

[Display(Name = "名稱")]

[DataType(DataType.Password)]

[EmailAddress]

[StringLength(100, ErrorMessage = "{0} 的長度至少必須為 {2} 個字元。", MinimumLength = 6)]

[Compare("Password", ErrorMessage = "密碼和確認密碼不相符。")]

[Phone]

public IList<UserLoginInfo> Logins { get; set; }