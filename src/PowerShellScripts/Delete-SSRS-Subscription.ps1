<#
.SYNOPSIS
    Delete SSRS Subscription

.DESCRIPTION
    Takes in arguments and uses those to delete a report subscription in SSRS

.NOTES
    Some useful links:
    https://www.powershellgallery.com/packages/ReportingServicesTools/0.0.6.4  --> Where to download this library
    https://github.com/microsoft/ReportingServicesTools  --> Official Microsoft Github repo for this library
    https://www.mssqltips.com/sqlservertip/4738/powershell-commands-for-sql-server-reporting-services/  --> General tips
#>

$server = $args[0]
$report = $args[1]
$description = $args[2]
$owner = $args[3]

Get-RsSubscription -ReportServerUri $server -RsItem $report | `
#Where-Object {$_.Description -like "*$description*" -and $_.Owner -eq $owner} | `
Where-Object {$_.Description -eq $description -and $_.Owner -eq $owner} | `
Remove-RsSubscription -ReportServerUri $server -Confirm:$false # <-- THIS WILL RUN FOR EVERYTHING IT FINDS WITHOUT ASKING YOU TO CONFIRM EACH ITEM